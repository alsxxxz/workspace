package School;

import java.io.*;
import java.util.*;

public class PermMain {
           
    static int N = 4, C = 0, R = 3;  
    static int[] a = {1, 2, 3, 4}, b = new int[R];    // 원본 배열  // 선택된 원소를 담을 배열 (크기 3)
    static boolean[] v = new boolean[N];  // 방문 체크 (사용했는지 확인)

    static void perm(int cnt) { //depth, index 둘 다 가능.
        //재귀호출 id,else로 되어있음.
        //cnt라는 변수는 바뀌지 않고 read only
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return; //재귀종료
        }
        for (int i = 0; i < N; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true; //방문처리
            b[cnt] = a[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        C = 0;
        perm(0);
        System.out.println(C);
    }

}
