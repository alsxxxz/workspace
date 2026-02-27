
import java.util.*;

class Solution_swtest_프로세서연결하기_서울_8_박민주 {

    static int N;
    static int[][] board;
    static List<int[]> cores;
    static int maxCores;
    static int minWireLength;

    // 방향: 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            board = new int[N][N];
            cores = new ArrayList<>();

            // 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // 가장자리 아닌 Core만 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            cores.add(new int[]{i, j});
                        }
                    }
                }
            }

            // 초기화
            maxCores = 0;
            minWireLength = Integer.MAX_VALUE;

            // 백트래킹 시작
            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + minWireLength);
        }
    }

    // 백트래킹
    static void dfs(int idx, int connectedCores, int wireLength) {
        // 모든 core 처리 완료
        if (idx == cores.size()) {
            if (connectedCores > maxCores
                    || (connectedCores == maxCores && wireLength < minWireLength)) {
                maxCores = connectedCores;
                minWireLength = wireLength;
            }
            return;
        }

        int[] core = cores.get(idx);
        int row = core[0];
        int col = core[1];

        // 4방향 시도
        for (int dir = 0; dir < 4; dir++) {
            if (canInstall(row, col, dir)) {
                int len = installWire(row, col, dir);
                dfs(idx + 1, connectedCores + 1, wireLength + len);
                removeWire(row, col, dir);
            }
        }

        // 이 core를 연결 안하는 경우
        dfs(idx + 1, connectedCores, wireLength);
    }

    // 전선 설치 가능 여부 체크
    static boolean canInstall(int row, int col, int dir) {
        int r = row;
        int c = col;

        while (true) {
            r += dr[dir];
            c += dc[dir];

            // 가장자리 도달 성공
            if (r < 0 || r >= N || c < 0 || c >= N) {
                return true;
            }

            // 장애물 발견
            if (board[r][c] != 0) {
                return false;
            }
        }
    }

    // 전선 설치
    static int installWire(int row, int col, int dir) {
        int r = row;
        int c = col;
        int length = 0;

        while (true) {
            r += dr[dir];
            c += dc[dir];

            if (r < 0 || r >= N || c < 0 || c >= N) {
                break;
            }

            board[r][c] = 2;
            length++;
        }
        return length;
    }

    // 전선 제거
    static void removeWire(int row, int col, int dir) {
        int r = row;
        int c = col;

        while (true) {
            r += dr[dir];
            c += dc[dir];

            if (r < 0 || r >= N || c < 0 || c >= N) {
                break;
            }

            board[r][c] = 0;
        }
    }
}
