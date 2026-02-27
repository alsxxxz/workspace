
import java.io.*;
import java.util.*;

public class N과M {
    static int N, M;
    static int[] b;
    static int[] a;
    static boolean[] v;

    static void Perm(int cnt) {
        if (cnt == M) {
            System.out.println(Arrays.toString(b).split(""));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) {
                continue;
            }
                v[i] = true;
                b[cnt] = a[i];
                Perm(cnt + 1);
                v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        b = new int[M];
        a = new int[N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        Perm(0);
    }

}
