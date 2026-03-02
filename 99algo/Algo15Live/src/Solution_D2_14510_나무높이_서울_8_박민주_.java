
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public Solution_D2_14510_나무높이_서울_8_박민주_{
    static int T, N;
    static int[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            tree = new int[N];
            int maxH = 0;
            int one =0, two = 0, ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                maxH = Math.max(tree[i], maxH);
            }
            //diff는 4 3 3 - > one 2
            //전체가 아니라 매번 diff로 1일을 구분해서 받아야함
            //one, two에 매번 누적하고 다 끝나면 two만 잡기
            for(int j=0; j<N; j++){
                int diff = maxH-tree[j];
                one += diff%2; two += diff/2;
            }
            //밸런스 맞춰주기
            while (two>one+1) {one +=2; two--;}
            //one>two면 two생각하지말고 one*2 -1
            if(two>one) ans = two + one +1;
            else if (one>two) ans = (one*2)-1;
            else ans = two + one;
            System.out.println("#" + (tc+1) + " " + ans);
        }
    }
}
