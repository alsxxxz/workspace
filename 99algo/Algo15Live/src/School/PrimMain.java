
import java.util.*;
// 5
// 0 5 10 8 7
// 5 0 5 3 6
// 10 5 0 1 3
// 8 3 1 0 1
// 7 6 3 1 0 
//output->10

public class PrimMain {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //N:정점개수, G:인접 리스트, v:방문체크배열
        int N = sc.nextInt();
        List<int[]>[] G = new List[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        boolean[] v = new boolean[N];

        //------2. 그래프 구성-----
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int c = sc.nextInt();                     //Scanner.NextInt() 자동으로 공백 구분자로 인식
                if (c != 0) {
                    G[i].add(new int[]{j, c});    //c가 0이 아니면 i>j로 가는 간선(가중치 c) 추가
                }
            }
        }
        //-----3. Prim 알고리즘 준비 -----
        int[] P = new int[N];
        Arrays.fill(P, Integer.MAX_VALUE); //각 정점까지 최소 간선 비용
        int mst = 0, cnt = 0;                                       //MST 총비용, cnt: 선택한 간선 개수
        P[0] = 0;                                                //0번 정점부터 시작

        //-----4. 최소 비용 정점 선택-----. 아직 방문 안 한 정점 중에서 가장 작은 비용 P[j]을 가진 정점 찾기
        for (int i = 0; i < N; i++) {
            int minVertex = -1;                                 //최소 비용 정점 번호
            int min = Integer.MAX_VALUE;                          //최소 비용
            for (int j = 0; j < N; j++) {
                if (!v[j] && min > P[j]) {
                    min = P[j];
                    minVertex = j;
                }
            }
            //-----5.
            v[minVertex] = true;
            mst += min;
            if (cnt++ == N - 1) {
                break;
            }

            for (int[] j : G[minVertex]) {   // minVertex=0 , G[0] = [[1,5], [2,10], [3,8], [4,7]]
                if (!v[j[0]] && P[j[0]] > j[1]) { //P의 j[0] 이정점, j[1]이 가중치
                    P[j[0]] = j[1];
                }
                //ㅍㅍㅍ
            }
        }
        System.out.println(mst);
        sc.close();
    }
}
