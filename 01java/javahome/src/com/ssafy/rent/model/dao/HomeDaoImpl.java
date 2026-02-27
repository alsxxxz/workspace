package com.ssafy.rent.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomeInfo;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.util.DBUtil;
import com.ssafy.rent.util.HomeSaxParser;

/**
 * 엑셀 파일 기반 HomeDaoImpl
 * F01: 주택 실거래가 정보 수집 기능 구현
 */
public class HomeDaoImpl implements HomeDao {

    private Map<String, HomeInfo> homeInfo;
    private Map<String, List<HomeDeal>> deals;
    private int size;
    private List<HomeDeal> search;
    private String[] searchType = { HomeDeal.APT_DEAL, HomeDeal.APT_RENT, HomeDeal.HOME_DEAL, HomeDeal.HOME_RENT };

    public HomeDaoImpl() {
        loadData();
    }

    /**
     * F01: 주택 실거래가 정보 수집
     * 1. 엑셀 파일에서 데이터 읽기
     * 2. 데이터 가공
     * 3. DB 저장
     */
    public void loadData() {
    	HomeSaxParser parser = new HomeSaxParser();
        homeInfo = parser.getHomeInfo();
        deals = parser.getDeals();
        size = parser.getSize();
        search = new ArrayList<HomeDeal>(size);
    }
    
    /**
     * 거래 정보에서 아파트 기본 정보 추출
     */
    private Map<String, HomeInfo> extractHomeInfo() {
        Map<String, HomeInfo> infoMap = new HashMap<>();
        
        for (List<HomeDeal> dealList : deals.values()) {
            for (HomeDeal deal : dealList) {
                String key = deal.getDong() + deal.getAptName();
                
                if (!infoMap.containsKey(key)) {
                    HomeInfo info = new HomeInfo();
                    info.setDong(deal.getDong());
                    info.setAptName(deal.getAptName());
                    info.setBuildYear(deal.getBuildYear());
                    info.setJibun(deal.getJibun());
                    infoMap.put(key, info);
                }
            }
        }
        
        return infoMap;
    }
    
    /**
     * DB에 저장
     */
    private void saveToDatabase() {
        saveHomeInfoToDB();
        saveDealsToDB();
    }
    
    /**
     * HomeInfo를 DB에 저장
     */
    private void saveHomeInfoToDB() {
        String sql = "INSERT INTO homeinfo (dong, apt_name, build_year, jibun) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "build_year=VALUES(build_year), jibun=VALUES(jibun)";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            int count = 0;
            for (HomeInfo info : homeInfo.values()) {
                pstmt.setString(1, info.getDong());
                pstmt.setString(2, info.getAptName());
                pstmt.setInt(3, info.getBuildYear());
                pstmt.setString(4, info.getJibun());
                pstmt.addBatch();
                
                count++;
                if (count % 1000 == 0) {
                    pstmt.executeBatch();
                    System.out.println("  HomeInfo " + count + "건 저장...");
                }
            }
            
            pstmt.executeBatch();
            System.out.println("✓ HomeInfo 총 " + homeInfo.size() + "건 DB 저장 완료!");
            
        } catch (SQLException e) {
            System.err.println("HomeInfo 저장 실패: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }
    
    /**
     * HomeDeal을 DB에 저장
     */
    private void saveDealsToDB() {
        String sql = "INSERT INTO homedeal (dong, apt_name, deal_amount, build_year, " +
                     "deal_year, deal_month, deal_day, area, floor, jibun, type, rent_money) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            
            int count = 0;
            for (List<HomeDeal> dealList : deals.values()) {
                for (HomeDeal deal : dealList) {
                    pstmt.setString(1, deal.getDong());
                    pstmt.setString(2, deal.getAptName());
                    pstmt.setString(3, deal.getDealAmount());
                    pstmt.setInt(4, deal.getBuildYear());
                    pstmt.setInt(5, deal.getDealYear());
                    pstmt.setInt(6, deal.getDealMonth());
                    pstmt.setInt(7, deal.getDealDay());
                    pstmt.setDouble(8, deal.getArea());
                    pstmt.setInt(9, deal.getFloor());
                    pstmt.setString(10, deal.getJibun());
                    pstmt.setString(11, deal.getType());
                    pstmt.setString(12, deal.getRentMoney());
                    pstmt.addBatch();
                    
                    count++;
                    if (count % 5000 == 0) {
                        pstmt.executeBatch();
                        System.out.println("  HomeDeal " + count + "건 저장...");
                    }
                }
            }
            
            pstmt.executeBatch();
            System.out.println("✓ HomeDeal 총 " + size + "건 DB 저장 완료!");
            
        } catch (SQLException e) {
            System.err.println("HomeDeal 저장 실패: " + e.getMessage());
            e.printStackTrace();
        } finally {
            DBUtil.close(pstmt, conn);
        }
    }

    /**
     * F02: 검색 조건에 맞는 아파트 거래 정보 검색
     */
    public List<HomeDeal> searchAll(HomePageBean bean) {
        search.clear();
        List<HomeDeal> finds = new LinkedList<>();
        if (deals == null) {
            return finds;
        }
        boolean[] type = bean.getSearchType();
        for (int i = 0, size = type.length; i < size; i++) {
            if (type[i]) {
                search.addAll(deals.get(searchType[i]));
            }
        }
        
        String dong = bean.getDong();
        String aptName = bean.getAptname();
        if (dong != null) {
            for (HomeDeal deal : search) {
                if (deal.getDong().contains(dong)) {
                    finds.add(deal);
                }
            }
        } else if (aptName != null) {
            for (HomeDeal deal : search) {
                if (deal.getAptName().contains(aptName)) {
                    finds.add(deal);
                }
            }
        } else {
            finds = search;
        }
        return finds;
    }

    /**
     * F02: 아파트 식별 번호로 거래 정보 검색
     */
    public HomeDeal search(int no) {
        // complete code #03
        // List<HomeDeal> search 로부터 no 에 해당하는 HomeDeal 정보를 검색하여 return 하도록 코드를 작성하세요.
        // 해당하는 no 가 없을 경우 null 을 리턴하세요.
    	return search.stream()
    		.filter(homeDeal -> homeDeal.getNo() == no)
    		.findFirst().orElse(null);
    }
}