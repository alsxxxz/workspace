
import java.io.*;
import java.util.*;

public class Solution_D3_399_퍼펙트셔플_서울_8반_박민주 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer((br.readLine()));

            String[] cards = new String[N];
            for (int i = 0; i < N; i++) {
                cards[i] = st.nextToken();
            }

        }
        int mid = (N + 1) / 2;
        String[] front = new String[mid];
        String[] back = new String[N - mid];

        for (int i = 0; i < mid; i++) {
            front[i] = cards[i];
        }

        for (int i = 0; i < N - mid; i++) {
            back[i] = cards[mid + i];
        }

        sb.append("#").append(tc).append(" ");
        for (int i = 0; i < back.length; i++) {
            sb.append(front[i]).append(" ");
            sb.append(back[i]).append(" ");
        }

        if (N % 2 == 1) {
            sb.append(front[mid - 1]);
        }

        sb.append("\n");
    }

    System.out.print (sb);
}
}
