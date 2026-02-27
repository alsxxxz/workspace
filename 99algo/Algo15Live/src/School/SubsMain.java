package School;

import java.io.*;

public class SubsMain {
    static int N = 4;              // 전체 원소 개수 (1,2,3,4)
    static int C = 0;              // 경우의 수 카운트
    static int[] a = {1, 2, 3, 4};    // 원본 배열

//    static void subs(int cnt, String str) {
//            if (cnt==N) {
//            	System.out.println(str); C++;
//                return;
//            }
//            subs(cnt + 1, str+"_");
//            subs(cnt + 1, str+a[cnt]);
//    	}

    static void subs(int cnt, String str, int R) {
    	if(R==3) {
    		System.out.println(str); C++;
    		return;
    	}
        ///*********** 이거 빠지면 OutOfIndex */
        if (cnt==N) {
            return;
        }
        subs(cnt + 1, str+"_", 	R);
        subs(cnt + 1, str+a[cnt], R+1);
	}
    public static void main(String[] args) throws IOException {
        C = 0;
        //subs(0, "");
        subs(0, "",0);
        System.out.println(C);
    }
}

