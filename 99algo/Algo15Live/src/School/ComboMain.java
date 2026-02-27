package School;

import java.io.*;
import java.util.*;

public class ComboMain {

    static int N = 4;              // 전체 원소 개수 (1,2,3,4)
    static int R = 3;              // 뽑을 개수
    static int C = 0;              // 경우의 수 카운트

    static int[] a = {1, 2, 3, 4};    // 원본 배열
    static int[] b = new int[R];   // 선택된 원소를 담을 배열 (크기 3)
    static boolean[] v = new boolean[N];  // 방문 체크 (사용했는지 확인)

    static void comb(int cnt, int start) { //depth, index 둘 다 가능.
        if (cnt == R) {
            System.out.println(Arrays.toString(b));
            C++;
            return;
        }
        for (int i = start; i < N; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true; //방문처리
            b[cnt] = a[i];
            comb(cnt + 1, i + 1);//comb(cnt+1, i);면 뭐가 다르고
        }
    }

    static void comb1(int start, String str) { //depth, index 둘 다 가능. w조합이 아니라 부분집합
        System.out.println(str);
        C++;
        for (int i = start; i < N; i++) {
            comb1(i + 1, str + a[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        C = 0;
        comb(0, 0);
        System.out.println(C);
    }

}
