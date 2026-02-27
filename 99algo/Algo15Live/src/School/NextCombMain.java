
import java.util.Arrays;//
//w조합

public class NextCombMain {

    static int N = 4, C = 0;
    static int[] a = {0, 0, 1, 1};
    static char[] b = {'A', 'B', 'C', 'D'};

    static void swap(int i, int j) {
        int T = a[i];
        a[i] = a[j];
        a[j] = T;
    }

    static boolean npn() {
        int i = N - 1; //i 교환위치찾기
        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }

        int j = N - 1; //j 교환할값 찾기
        while (i > 0 && a[i - 1] >= a[j]) {
            j--;
        }
        swap(i - 1, j);

        int k = N - 1; //k 오름차순 정렬
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        C = 0;
        Arrays.sort(a);
        do {
            System.out.println(Arrays.toString(a));
            C++;
            System.out.println();
            for (int i = 0; i < N; i++) {
                System.out.print(a[i] != 0 ? b[i] : "_");
            }
            System.out.println();
        } while (npn());
        System.out.println(C);
    }
}
