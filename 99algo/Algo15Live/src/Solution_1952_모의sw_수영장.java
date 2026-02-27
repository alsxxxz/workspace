import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_1952_모의sw_수영장 {
static int T;
static List<Integer> priceList,monthList ;
static int totalCost = 0;
  static int dfs(int month){
    
    int cnt = 0;
    //12월이 되면 멈춰야함
    if(month == 12) return totalCost;
    //12월이 아니면 1월엔 뭘 원상복구시켜야..
    //0일인경우
    if(monthList.get(month) )
    //하루
    //한달
    //3개월

    }
  }
 //하루 한달 


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      //이용권 가격들

    priceList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    monthList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    

}
}