import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Solution {
    public static void main(String args[]) throws IOException {
        // BufferedReader로 파일 읽기
        BufferedReader br = new BufferedReader(
            new FileReader("C:\\SSAFY\\workspace\\homework\\0203\\res\\d3_input.txt")
        );
        
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] farm = new int[N][N];
            
            // 농장 데이터 입력
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }
            
            // 수익 계산
            int result = calculateProfit(N, farm);
            System.out.println("#" + test_case + " " + result);
        }
        
        br.close();
    }
    
    public static int calculateProfit(int N, int[][] farm) {
        int mid = N / 2;
        int total = 0;
        
        for(int i = 0; i < N; i++) {
            // 중심에서의 거리
            int dist = Math.abs(i - mid);
            // 마름모 범위 계산
            int rangeSize = mid - dist;
            
            // 해당 행에서 수확
            for(int j = mid - rangeSize; j <= mid + rangeSize; j++) {
                total += farm[i][j];
            }
        }
        
        return total;
    }
}