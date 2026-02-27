
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5643_키순서_서울_8반_박민주 {

    static int T, N, M;
    static List<ArrayList<Integer>> smaller, bigger;
    static boolean[] v;
    static int answer;

    static int dfs(int node, List<ArrayList<Integer>> G) {
        int cnt = 1; //
        v[node] = true;
        for (int next : G.get(node)) {
            if (!v[next]) {
                cnt += dfs(next, G);
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            answer = 0;
            // bigger, smaller 학생 수 만큼 만들기
            bigger = new ArrayList<>();
            smaller = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                bigger.add(new ArrayList<>());
                smaller.add(new ArrayList<>());
            }
            //bigger, smaller에 st로 값 배정
            for (int i = 1; i <= M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                bigger.get(S).add(L);
                smaller.get(L).add(S);
            }
            for (int i = 1; i <= N; i++) {
                v = new boolean[N + 1];
                int biggercnt = dfs(i, bigger) - 1;
                v = new boolean[N + 1];
                int smallercnt = dfs(i, smaller) - 1;

                if (biggercnt + smallercnt == N - 1) {
                    answer += 1;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }

    }

}
