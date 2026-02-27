import java.io.*;
import java.util.*;

public class DiceTest {

private static boolean[] isSelected;
private static int[] numbers;
private static int N, totalCnt;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
   
    int mode = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    totalCnt = 0;

    numbers = new int[N];

        switch (mode) {
        case 1: //중복순열
            dice1(0);
            break;
        case 2: //순열
            isSelected = new boolean[7];
            dice2(0);
            break;
        case 3: //중복조합
            dice3(0,1);
            break;
        case 4://조합
            dice4(0,1);
            break;
        default:
            break;
        }
        System.out.println("총 경우의 수: " + totalCnt);
}

public static void dice1(int cnt){
    if(cnt == N){
        ++totalCnt;
        System.out.println(Arrays.toString(numbers));
        return;
    }
    for(int i = 1; i <= 6; i++){
        numbers[cnt] = i;
        dice1(cnt+1);
    }
}

public static void dice2(int cnt){ //2. 순열
    if(cnt == N){
        ++totalCnt;
        System.out.println(Arrays.toString(numbers));
        return;
    }
    for(int i = 1; i <= 6; i++){
        if(isSelected[i]) continue;
        isSelected[i] = true;
        numbers[cnt] = i;
        dice2(cnt+1);
        isSelected[i] = false;
    }
}

public static void dice3(int cnt, int start) {
    if(cnt == N) {
        ++totalCnt;
        System.out.println(Arrays.toString(numbers));
        return;
    }
    for (int i = start; i <= 6; i++) {
        numbers[cnt] = i;
        dice3(cnt+1, i);
    }
}

    public static void dice4(int cnt, int start) { // 조합
        if(cnt == N) {
        ++totalCnt;
        System.out.println(Arrays.toString(numbers));
        return;
        }
        for (int i = start; i <= 6; i++) {
        numbers[cnt] = i;
        dice4(cnt+1, i+1);

    }
    }
}