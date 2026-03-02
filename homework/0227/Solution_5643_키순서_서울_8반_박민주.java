
import java.io.*;
import java.util.*;

public class Solution_5643_키순서_서울_8반_박민주 {

    static int T, N, M;
    static List<ArrayList<Integer>> smaller, bigger;
    static boolean[] v;

    static int dfs(int Node, List<ArrayList<Integer>> G) {
        int cnt = 1;
        v[Node] = true;
        for (int next : G.get(Node)) {
            if (!v[next]) { //방문체크 해야함
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
            smaller = new ArrayList<>();
            bigger = new ArrayList<>();
            int ans = 0;
            for (int i = 0; i <= N; i++) {
                //1부터 N은 인덱스 0~ N-1번 반복
                //이건 인덱스이니 0부터 시작해서 N까지 가야 N까지감
                smaller.add(new ArrayList<>());
                bigger.add(new ArrayList<>());
            }
            M = Integer.parseInt(br.readLine());
            for (int j = 1; j <= M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                smaller.get(B).add(S);
                bigger.get(S).add(B);
            }
            for (int i = 1; i <= N; i++) {
                //크기는 항상 +1
                v = new boolean[N + 1];
                int ss = dfs(i, smaller) - 1;

                v = new boolean[N + 1];
                int bb = dfs(i, bigger) - 1;
                if ((ss + bb) == N - 1) {
                    ans += 1;
                }
            }
            System.out.println("#" + (tc + 1) + " " + ans);
        }
    }
}
