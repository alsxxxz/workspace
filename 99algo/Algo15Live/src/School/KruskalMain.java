/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10
 */
import java.util.*;
//최소신장트리: 모든 노드를 최소 비용으로 연결하는 트리
public class KruskalMain {
    static int N;
    static int[][] G;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        int E = sc.nextInt();
        G = new int[E][3];
        for(int i=0; i<E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            G[i] = new int[] {from, to, weight};
        }

        for(int[] a: G) System.out.println(Arrays.toString(a));
        System.out.println();
        Arrays.sort(G,(o1,o2) -> Integer.compare(o1[2], o2[2]));
        sc.close();
    }
}

