
import java.util.*;

public class Solution_D4_장훈이의높은선반_서울_8_박민주 {

    static int N, B, answer;
    static int[] H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            B = sc.nextInt();
            H = new int[N];

            for (int i = 0; i < N; i++) {
                H[i] = sc.nextInt();
            }

            answer = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.println("#" + tc + " " + (answer - B));
        }
        sc.close();
    }

    // idx: 현재 점원 인덱스, sum: 현재까지 키의 합
    static void dfs(int idx, int sum) {
        // 이미 B 이상이면서 최소값보다 크면 가지치기
        if (sum >= B) {
            answer = Math.min(answer, sum);
            return;
        }

        // 모든 점원 확인 완료
        if (idx == N) {
            return;
        }

        // 현재 점원 포함
        dfs(idx + 1, sum + H[idx]);

        // 현재 점원 미포함
        dfs(idx + 1, sum);
    }
}
