
import java.util.*;

public class Subset {

    static int N, input[], totalCnt;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int targetSum = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N]; // |#: false

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        makeSubSet(0);
        makeSubSetSum(0, 0, totalCnt);
        System.out.println("모든 경우의 수: " + totalCnt);
    }

    public static void makeSubSet(int cnt) { //원소관점으로 처리, cnt:앞쪽까지 고려한 원소수
        //기저조건
        if (cnt == N) {//모든 원소가 고려되었다.
            ++totalCnt;
            for (int i = 0; i < N; i++) {
                System.out.println((isSelected[i] ? input[i] : "X") + "\t");
            }
            System.out.println();
            return;
        }
        //해당 원소용 부분집합 구성에 넣기
        isSelected[cnt] = true;
        makeSubSet(cnt + 1);
        //해당 원소를 부분집합 구성에 넣지 않기
        isSelected[cnt] = false;
        makeSubSet(cnt + 1);

    }

    public static void makeSubSetSum(int cnt, int PickCnt, int targetSum) { //원소관점으로 처리
        ///cnt:현재까지 고려한 원소의 개수(인덱스), PickCnt:현재까지 부분집합에 실제로 선택한 원소의 개수, targetSum: 찾고자하는 목표합
        //기저조건
        if (cnt == N) {
            int sum = 0;//모든 원소가 고려되었다.
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sum = input[i];
                }
            }
            if (PickCnt > 0 && targetSum == sum) {
                ++totalCnt; //공집합 제거
            }
            return;
        }

//해당 원소용 부분집합 구성에 넣기
        isSelected[cnt] = true;
        makeSubSetSum(cnt + 1, PickCnt + 1, targetSum);
//해당 원소를 부분집합 구성에 넣지 않기
        isSelected[cnt] = false;
        makeSubSetSum(cnt + 1, PickCnt, targetSum);

    }
}
//--동주님코드
static int arraySize = 5;
static int[] array = new int[arraySize];

static boolean[] isSelected = new boolean[arraySize];
static int subsetCount = 0;

static void makeSubset(int idx) {
    if (idx == arraySize) {
        subsetCount++;
        for (int i = 0; i < arraySize; i++) {
            if(isSelected[i]){
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println();
        return;
    }

    // idx번 원소를 선택하지 않은 경우
    makeSubset(idx+1);
    // idx번 원소를 선택한 경우
    isSelected[idx] = true;
    makeSubset(idx+1);
    isSelected[idx] = false;
}

public static void main(String[] args) {
    for (int i = 0; i < arraySize; i++) {
        array[i] = i;
    }
    makeSubset(0);
} 