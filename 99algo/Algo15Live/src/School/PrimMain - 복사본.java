
import java.io.*;
import java.util.*;
// 5
// 0 5 10 8 7
// 5 0 5 3 6
// 10 5 0 1 3
// 8 3 1 0 1
// 7 6 3 1 0 
//output->10
public class primMain-복사본{
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    //N:정점개수, G:인접 리스트, v:방문체크배열
    int N = sc.nextInt();
    List<int[]>[] G = new List[N];
    for(int i=0; i<N; i++){
        G[i] = new ArrayList<>();}
    boolean [] v = new boolean[N];

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            int c = sc.nextInt();
            G[i] = c
        }
    }

}
