
import java.io.*;
import java.util.StringTokenizer;

public class Solution_D2_14510_나무높이_서울_8_박민주 {

    static int T, N;
    static int[] tree;
    static int maxH, one, two;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            maxH = 0;
            tree = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, tree[i]);
            }
            int ans = 0;
            two = 0;
            one = 0;
            for (int i = 0; i < N; i++) {
                int howMuchW = maxH - tree[i];	 //나무별로 구해야해서 여기서 초기화 해줘야함
                two += howMuchW / 2;
                one += howMuchW % 2;
            }
            //two가 one보다 2개 이상 많을 때 밸런스 맞춰주기
            while (two > one + 1) {
                two--;
                one += 2;
            }

            if (one > two) {
                ans = (one * 2) - 1; 
            }else if (two > one) {
                ans = two + two; 
            }else {
                ans = two + one;
            }
            System.out.println("#" + " " + (tc + 1) + " " + ans);
        }

    }
}
