
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Solution_1952_모의sw_수영장 {
static int T;
static List<Integer> priceList, monthList ;
static int totalCost = Integer.MAX_VALUE;
  static void dfs(int month, int sum){
    
    //12월이 되면 멈춰야함
    if(month == 12) sum = Math.min(sum, totalCost);
    return;

    //0일인경우
    if(monthList.get(month) == 0) dfs(month+1, sum); return;

      dfs( (month + 1) , sum += monthList.get(month)*priceList.get(0));
      dfs((month + 1) , sum + priceList.get(1));
      dfs((month + 3), sum += priceList.get(3));
    //한달
    //3개월
    }
    }

 //하루 한달


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
    priceList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    monthList = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
}
}
}
