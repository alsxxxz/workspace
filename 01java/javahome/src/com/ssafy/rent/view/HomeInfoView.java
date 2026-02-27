package com.ssafy.rent.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.model.service.HomeService;
import com.ssafy.rent.model.service.HomeServiceImpl;


public class HomeInfoView{
	
	// 토스 컬러 팔레트 - 더 진하게
	private static final Color TOSS_BLUE = new Color(0, 75, 215);
	private static final Color TOSS_BLUE_DARK = new Color(0, 50, 150);
	private static final Color TOSS_BLUE_LIGHT = new Color(230, 240, 255);
	private static final Color TOSS_BG = new Color(245, 247, 250);
	private static final Color TOSS_WHITE = Color.WHITE;
	private static final Color TOSS_GRAY = new Color(50, 60, 70);
	private static final Color TOSS_LIGHT_GRAY = new Color(240, 242, 245);
	private static final Color TOSS_BORDER = new Color(200, 205, 210);
	private static final Color TOSS_BORDER_BOLD = new Color(150, 160, 170);
	
	// 토스 폰트 - 더 두껍게
	private static final Font TOSS_TITLE_FONT = new Font("맑은 고딕", Font.BOLD, 28);
	private static final Font TOSS_SUBTITLE_FONT = new Font("맑은 고딕", Font.BOLD, 20);
	private static final Font TOSS_BODY_FONT = new Font("맑은 고딕", Font.BOLD, 15);
	private static final Font TOSS_LABEL_FONT = new Font("맑은 고딕", Font.BOLD, 13);
	private static final Font TOSS_BUTTON_FONT = new Font("맑은 고딕", Font.BOLD, 16);
	
	/**models */
	private HomeService 		homeService;
	
	/** main 화면 */
	private JFrame frame;
	
	/**주택 이미지 표시 Panel*/
	private JLabel	 			imgL;
	private JLabel[] 			homeInfoL;
	
	/**조회 조건*/
	private JCheckBox[]		  	chooseC;
	private JComboBox<String> 	findC; 
	private JTextField		  	wordTf;
	private JButton			  	searchBt;
	
	/**조회 내용 표시할 table*/
	private DefaultTableModel 	homeModel;
	private JTable			  	homeTable;
	private JScrollPane		  	homePan;
	private String[]		  	title = { "번호", "동", "아파트이름", "거래금액", "거래종류" };
	
	/**검색  조건*/
	private String	key;
	
	/**검색할 단어*/
	private String  word;
	private boolean[] searchType = { true, true, true, true };
	private String[] choice = { "all", "dong", "name" };
	
	/**화면에 표시하고 있는 주택*/
	private HomeDeal curHome;

	
	private void showHomeInfo(int code) {
		curHome = homeService.search(code);
		System.out.println("curHome: " + curHome);
		
		homeInfoL[0].setText("");
		homeInfoL[1].setText("");
		homeInfoL[2].setText(curHome.getAptName());
		homeInfoL[3].setText(curHome.getDealAmount() + "만원");
		String rent = curHome.getRentMoney();
		if(rent == null) {
			homeInfoL[4].setText("없음");
		}else {
			homeInfoL[4].setText(curHome.getRentMoney() + "만원");
		}
		homeInfoL[5].setText(curHome.getBuildYear() + "년");
		homeInfoL[6].setText(curHome.getArea() + "㎡");
		homeInfoL[7].setText(String.format("%d년 %d월 %d일"
											,curHome.getDealYear()
											,curHome.getDealMonth()
											,curHome.getDealDay()
											));
		homeInfoL[8].setText(curHome.getDong());
		homeInfoL[9].setText(curHome.getJibun());
		
		ImageIcon icon = null;
		if( curHome.getImg() != null && curHome.getImg().trim().length() != 0) {
			icon = new ImageIcon("img/" + curHome.getImg());
		}else {
			icon = new ImageIcon("img/다세대주택.jpg");
		}
		imgL.setIcon(icon);
	}
	
	public HomeInfoView(){
		/*Service들 생성 */
		homeService = new HomeServiceImpl();
		
		/*메인 화면 설정*/
		frame = new JFrame("🏠 SSAFY Home");
		frame.getContentPane().setBackground(TOSS_BG);
		
		setMain();
		
		frame.setSize(1500, 950);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		showHomeInfo(1);
	}

	/**메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드  */
	public void setMain(){
		
		/*왼쪽 화면을 위한 설정 */
		JPanel left = new JPanel(new BorderLayout());
		left.setBackground(TOSS_WHITE);
		left.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true),
			BorderFactory.createEmptyBorder(35, 35, 35, 35)
		));
		
		// 제목
		JLabel titleLabel = new JLabel("🏘️ 아파트 거래 정보", SwingConstants.CENTER);
		titleLabel.setFont(TOSS_TITLE_FONT);
		titleLabel.setForeground(TOSS_GRAY);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 35, 0));
		
		JPanel leftCenter = new JPanel(new GridLayout(1, 2, 25, 0));
		leftCenter.setBackground(TOSS_WHITE);
		
		// 이미지 패널 - 더 뚜렷한 테두리
		JPanel imgPanel = new JPanel(new BorderLayout());
		imgPanel.setBackground(TOSS_LIGHT_GRAY);
		imgPanel.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 3, true),
			BorderFactory.createEmptyBorder(15, 15, 15, 15)
		));
		imgL = new JLabel();
		imgL.setHorizontalAlignment(SwingConstants.CENTER);
		imgPanel.add(imgL, BorderLayout.CENTER);
		
		// 정보 패널
		JPanel leftR = new JPanel(new GridLayout(10, 2, 15, 20));
		leftR.setBackground(TOSS_WHITE);
		
		String[] info= {"","","🏢 주택명","💰 거래금액","💳 월세금액","📅 건축연도","📐 전용면적","🗓️ 거래일","📍 법정동","🗺️ 지번"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		homeInfoL = new JLabel[size];
		
		for (int i = 0; i < size; i++) {
			infoL[i] = new JLabel(info[i]);
			infoL[i].setFont(TOSS_LABEL_FONT);
			infoL[i].setForeground(TOSS_GRAY);
			
			homeInfoL[i] = new JLabel("");
			homeInfoL[i].setFont(TOSS_BODY_FONT);
			homeInfoL[i].setForeground(Color.BLACK);
			
			leftR.add(infoL[i]);
			leftR.add(homeInfoL[i]);
		}
		
		leftCenter.add(imgPanel);
		leftCenter.add(leftR);
		
		left.add(titleLabel, "North");
		left.add(leftCenter, "Center");
		
		
		/*오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		right.setBackground(TOSS_BG);
		right.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		
		// 검색 패널
		JPanel rightTop = new JPanel(new BorderLayout(0, 20));
		rightTop.setBackground(TOSS_WHITE);
		rightTop.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true),
			BorderFactory.createEmptyBorder(30, 30, 30, 30)
		));
		
		// 체크박스 패널
		JPanel checkboxPanel = new JPanel(new GridLayout(2, 2, 15, 15));
		checkboxPanel.setBackground(TOSS_WHITE);
		
		String[] chooseMeg= { "🏢 아파트 매매", "🔑 아파트 전월세", "🏠 주택 매매", "🏡 주택 전월세"};
		chooseC = new JCheckBox[chooseMeg.length];
		
		for (int i = 0, len= chooseMeg.length; i < len; i++) {
			chooseC[i] = new JCheckBox(chooseMeg[i], true);
			chooseC[i].setFont(TOSS_BODY_FONT);
			chooseC[i].setBackground(TOSS_WHITE);
			chooseC[i].setForeground(TOSS_GRAY);
			chooseC[i].setFocusPainted(false);
			chooseC[i].setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(TOSS_BORDER, 2, true),
				BorderFactory.createEmptyBorder(12, 15, 12, 15)
			));
			chooseC[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			
			// 체크박스 호버 효과
			final int index = i;
			chooseC[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if(chooseC[index].isSelected()) {
						chooseC[index].setBackground(TOSS_BLUE_LIGHT);
					}
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					chooseC[index].setBackground(TOSS_WHITE);
				}
			});
			
			checkboxPanel.add(chooseC[i]);
		}
		
		// 검색바 패널
		JPanel searchPanel = new JPanel(new BorderLayout(15, 0));
		searchPanel.setBackground(TOSS_WHITE);
		
		String[] item = {"🔍 전체","📍 동","🏢 아파트 이름"}; 
		findC = new JComboBox<String>(item);
		findC.setFont(TOSS_BODY_FONT);
		findC.setBackground(TOSS_WHITE);
		findC.setBorder(BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true));
		findC.setPreferredSize(new Dimension(150, 50));
		findC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		wordTf = new JTextField();
		wordTf.setFont(TOSS_BODY_FONT);
		wordTf.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true),
			BorderFactory.createEmptyBorder(5, 20, 5, 20)
		));
		wordTf.setPreferredSize(new Dimension(0, 50));
		
		// 포커스 효과
		wordTf.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent e) {
				wordTf.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(TOSS_BLUE, 3, true),
					BorderFactory.createEmptyBorder(5, 20, 5, 20)
				));
			}
			public void focusLost(java.awt.event.FocusEvent e) {
				wordTf.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true),
					BorderFactory.createEmptyBorder(5, 20, 5, 20)
				));
			}
		});
		
		searchBt = createTossButton("🔎 검색");
		searchBt.setPreferredSize(new Dimension(120, 50));
		
		searchPanel.add(findC, BorderLayout.WEST);
		searchPanel.add(wordTf, BorderLayout.CENTER);
		searchPanel.add(searchBt, BorderLayout.EAST);
		
		rightTop.add(checkboxPanel, BorderLayout.NORTH);
		rightTop.add(searchPanel, BorderLayout.SOUTH);
		
		// 테이블 패널
		JPanel rightCenter = new JPanel(new BorderLayout());
		rightCenter.setBackground(TOSS_WHITE);
		rightCenter.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true),
			BorderFactory.createEmptyBorder(30, 30, 30, 30)
		));
		
		JLabel tableTitle = new JLabel("📋 거래 내역", SwingConstants.LEFT);
		tableTitle.setFont(TOSS_SUBTITLE_FONT);
		tableTitle.setForeground(TOSS_GRAY);
		tableTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));
		
		homeModel = new DefaultTableModel(title, 20);
		homeTable = new JTable(homeModel);
		
		// 테이블 스타일링 - 더 진하게
		homeTable.setFont(TOSS_BODY_FONT);
		homeTable.setRowHeight(60);
		homeTable.setShowGrid(true);
		homeTable.setGridColor(TOSS_BORDER);
		homeTable.setIntercellSpacing(new Dimension(1, 1));
		homeTable.setSelectionBackground(TOSS_BLUE_LIGHT);
		homeTable.setSelectionForeground(TOSS_BLUE_DARK);
		homeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		// 테이블 헤더 스타일링 - 더 진하게
		JTableHeader header = homeTable.getTableHeader();
		header.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		header.setBackground(TOSS_BLUE);
		header.setForeground(TOSS_WHITE);
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, TOSS_BLUE_DARK));
		header.setPreferredSize(new Dimension(0, 55));
		
		// 셀 렌더러 - 번갈아가며 색상
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
			@Override
			public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus, int row, int column) {
				java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (!isSelected) {
					if (row % 2 == 0) {
						c.setBackground(TOSS_WHITE);
					} else {
						c.setBackground(new Color(252, 253, 255));
					}
				}
				return c;
			}
		};
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < homeTable.getColumnCount(); i++) {
			homeTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		homePan = new JScrollPane(homeTable);
		homePan.setBorder(BorderFactory.createLineBorder(TOSS_BORDER_BOLD, 2, true));
		homePan.getViewport().setBackground(TOSS_WHITE);
		
		rightCenter.add(tableTitle, "North");
		rightCenter.add(homePan, "Center");
		
		right.add(rightTop, "North");
		right.add(rightCenter, "Center");
		
		// 메인 패널
		JPanel mainP = new JPanel(new GridLayout(1, 2, 25, 0));
		mainP.setBackground(TOSS_BG);
		mainP.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
		
		mainP.add(left);
		mainP.add(right);
		
		frame.add(mainP, "Center");
		
		/*이벤트 연결*/
		homeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = homeTable.getSelectedRow();
				System.out.println("선택된 row : " + row);
				System.out.println("선택된 row의 column 값 :" + homeModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String)homeModel.getValueAt(row, 0)).trim());
				showHomeInfo(code);
			}
		});
		
		searchBt.addActionListener(e -> searchHomes());
		
		showHomes();
	}
	
	// 토스 스타일 버튼 생성 - 더 입체적으로
	private JButton createTossButton(String text) {
		JButton button = new JButton(text);
		button.setFont(TOSS_BUTTON_FONT);
		button.setForeground(TOSS_WHITE);
		button.setBackground(TOSS_BLUE);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		button.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(TOSS_BLUE_DARK, 2, true),
			BorderFactory.createEmptyBorder(10, 25, 10, 25)
		));
		
		// 호버 + 클릭 효과
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(0, 90, 230));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(TOSS_BLUE);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				button.setBackground(TOSS_BLUE_DARK);
				button.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(TOSS_BLUE_DARK, 3, true),
					BorderFactory.createEmptyBorder(10, 25, 10, 25)
				));
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setBackground(new Color(0, 90, 230));
				button.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(TOSS_BLUE_DARK, 2, true),
					BorderFactory.createEmptyBorder(10, 25, 10, 25)
				));
			}
		});
		
		return button;
	}
	
	/**검색 조건에 맞는 주택 정보 검색 */
	private void searchHomes() {
		for(int i = 0, size = chooseC.length; i<size; i++) {
			if(chooseC[i].isSelected()) {
				searchType[i] = true;
			}else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:"+word+" key:"+key);
		showHomes();		
	}
	
	/**주택 목록을 갱신하기 위한 메서드 */
	public void showHomes(){
		HomePageBean  bean = new HomePageBean();
		bean.setSearchType(searchType);
		if(key != null) {
			if(key.equals("dong")) {
				bean.setDong(word);
			}else if(key.equals("name")) {
				bean.setAptname(word);
			}
		}
		
		List<HomeDeal> deals = homeService.searchAll(bean);
		if(deals != null){
			int i = 0;
			String[][] data = new String[deals.size()][5];
			for (HomeDeal deal: deals) {
				data[i][0] = "" + deal.getNo();
				data[i][1] = deal.getDong();
				data[i][2] = deal.getAptName();
				data[i][3] = deal.getDealAmount();
				data[i++][4] = deal.getType();
			}
			homeModel.setDataVector(data, title);
		}
	}
}