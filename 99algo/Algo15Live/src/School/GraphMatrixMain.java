
import java.util.*;

public class GraphMatrixMain {

    static int N;
    static int[][] G; //행렬
    static boolean[] v;//방문처리

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        G = new int[N][N];
        v = new boolean[N];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            G[from][to] = G[to][from] = 1;
        }
        for (int[] a : G) {
            System.out.println(Arrays.toString(a));
            System.out.println();
        }
        //bfs(0)
        dfs(0);
        sc.close();
    }

    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            System.out.print((char) (i + 'A') + " ");
            //for(int j=N-1; j>=0; j -- ){// N->
            for (int j = 0; j < N; j++) {// 0->N
                if (G[i][j] != 0 && !v[j]) {
                    v[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    static void dfs(int i) {
        //0부터 출발
        v[i] = true;
        System.out.print((char) (i + 'A') + " "); //그냥하느거
        //하고 싶은 코딩
        //다했다치고
        //여기서 0번 정점해서 할거다했으면 루프돌면서 1인 정점으로 방문(재귀호출)
        //for (int j = N - 1; j > 0; j--) {
        for (int j = 0; j < N; j++) {
            if (G[i][j] != 0 && !v[j]) { //방문 했으면 안됨
                dfs(j);
            }
        }
    }
}
