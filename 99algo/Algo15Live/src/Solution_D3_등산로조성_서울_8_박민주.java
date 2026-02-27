
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//등산로 조성 : 가장 높은 봉우리에서 출발해서 낮은 지형으로 사방탐색을해서 가장 긴 등산로를 만드는 문제
//길을 가다가 현재 위치보다 높거나 같은 곳은 딱 한 번 K만큼 깎아서 갈 수 있다.
//산의 크기가 최대 8*8로 비교적 작다. DFS를 활용

public class Solution_D3_등산로조성_서울_8_박민주 {

    static int N, K;
    static int[][] map;
    static boolean[][] v;
    static int maxLength;
    // 상하좌우 이동을 위한 배열 (위, 아래, 왼쪽, 오른쪽)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // N과 K 입력 받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지도의 크기
            K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

            map = new int[N][N];
            v = new boolean[N][N];
            maxLength = 0; // 최대 등산로 길이 초기화
            int maxHeight = 0; // 가장 높은 봉우리 의 높이

            // 1. 지도 정보 입력 , 가장 높은 봉우리 높이 찾기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }
            // 2. 가장 높은 봉우리에서 모두 DFS 탐색 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        v[i][j] = true;
                        dfs(i, j, 1, false);
                        v[i][j] = false;
                    }
                }
            }
            System.out.printf("#" + t + " " + maxLength + "\n");
        }

    }

    /*
     * r 현재 행 좌표
     *  c 현재 열 좌표
     * length 현재까지 조성한 등산로의 길이
     * skillUsed 지형 깎기 스킬 사용 여부
     */
    static void dfs(int r, int c, int length, boolean skillUsed) {
        // 매 탐색마다 최대 등산로 길이 갱신
        maxLength = Math.max(length, maxLength);
        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) { //0이어도됨
                if (!v[nr][nc]) {
                    //1. 다음 위치로 갈 수 있으면(현 위치보다 낮으면)
                    if (map[nr][nc] < map[r][c]) {
                        v[nr][nc] = true;
                        //dfs(nr, nc, length + 1, false);
                        dfs(nr, nc, length + 1, skillUsed); //이렇게 그대로 넣어줘야함 false는 이전과 관계없이 그냥 대입되는거
                        v[nr][nc] = false;

                    } //2. 다음 위치로 갈 수 없는데 > 공사 아직 안 했고 -K하면 현위치보다 낮아지는 경우
                    else if (!skillUsed && ((map[nr][nc] - K) < map[r][c])) {
                        int originalL = map[nr][nc];    //원래 높이 저장
                        map[nr][nc] = (map[r][c] - 1);  //갈수만 있도록 최소한만 현위치-1만 깎아준다. 앞으로도 본인보다 낮은위치로 가야하니까
                        v[nr][nc] = true;
                        dfs(nr, nc, length + 1, true);
                        v[nr][nc] = false;
                        map[nr][nc] = originalL;
                    }
                }
            }
        }
    }

}
