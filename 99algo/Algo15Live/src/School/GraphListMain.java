
import java.util.*;
// 0: [1, 2]
// 1: [0, 3, 4]
// 2: [0, 4]
// 3: [1, 5]
// 4: [1, 2, 5]
// 5: [3, 4, 6]
// 6: [5]

//그래프로 인접행렬과 리스트 표현가능**********************
//인접리스트 이거느 외워
public class GraphListMain {

    static int N;
    static List<Integer>[] G; //인접리스트
    static boolean[] v;//방문처리

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int E = sc.nextInt();
        G = new List[N];
        for (int i = 0; i < N; i++) {
            G = new ArrayList[N];  //여기 초기값 전부 Null > nillpointer Exception

                }v = new boolean[N];

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            G[from].add(to);
            G[to].add(from); //인접리스트는 이렇게 셋팅

        }
        for (List<Integer> a : G) {
            System.out.println(a);
            System.out.println();
        }
        //bfs(0)
//        dfs(0);
        sc.close();
    }

    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            i = q.poll();
            System.out.print((char) (i + 'A') + " ");
            for (int j : G[i]) {// 0->N
                if (!v[j]) {
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
        for (int j : G[i]) {
            if (!v[j]) { //안접한애들만 뽑았으니까 방문처리 할 ㅣ필요 없음

                dfs(j);
            }
        }
    }
}
