
import java.io.*;
import java.util.*;

public class Solution_D3_5215_햄버거다이어트_서울_8_박민주 {

    static boolean[] Selected; //조합에서 선택된 인덱스
    static int[][] ingridients;
    static int Num, Limit;
    static int MAX_LOVE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); //testcase
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= tc; i++) {
            //재료와 칼로리 제한 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            Num = Integer.parseInt(st.nextToken());
            Limit = Integer.parseInt(st.nextToken());

            //Num을 읽은 후에는 ingridients 초기화 필요
            ingridients = new int[Num][2];           //[2]가 love, cal
            Selected = new boolean[Num];

            for (int r = 0; r < Num; r++) {

                StringTokenizer TT = new StringTokenizer(br.readLine());
                int love = Integer.parseInt(TT.nextToken());
                int cal = Integer.parseInt(TT.nextToken());
                ingridients[r][0] = love;
                ingridients[r][1] = cal;
            }
            MAX_LOVE = 0;
            ham(0);
            sb.append("#").append(i).append(" ").append(MAX_LOVE).append("\n");
        }
        System.out.println(sb);
    }

    public static void ham(int cnt) { // 조합 1개부터 Num개까지의 조합

        //기저조건: 모든 재료를 "고려"했다. true인지 false인지
        if (cnt == Num) {
            int loveSum = 0;
            int calSum = 0;
            for (int i = 0; i < Num; i++) {
                if (Selected[i]) {
                    loveSum += ingridients[i][0];
                    calSum += ingridients[i][1];
                }
            }
            if (calSum <= Limit) {
                //System.out.print(Arrays.toString(ingridients[i]));
                if (loveSum > MAX_LOVE) {
                    MAX_LOVE = loveSum;
                }
            }
            return;

        }
        ham(cnt + 1);

        Selected[cnt] = true;
        ham(cnt + 1);
        Selected[cnt] = false;
    }

}
