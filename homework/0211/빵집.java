
import java.io.*;
import java.util.*;

public class 빵집 {
// 격자판에서 첫 번째 열(가스관)부터 마지막 열(빵집)까지 연결하는 파이프라인의 최대 개수를 구하는 DFS문제

    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 0, 1}; // 행의 방향 우선순위, 파이프를 최대한 위쪽으로 붙어야 아래쪽 공간이 많이 남는다.
    static int answer = 0;        //파이프 개수

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   //행
        C = Integer.parseInt(st.nextToken());   //열
        map = new char[R][C];                   //입력받은 행과 열로 map

//1. 맵 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j); //한줄씩 읽고 char로 map에 넣기
            }
        }

//3. 메인
        //0부터 R-1행까지 파이프 연결 시도
        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) { //C가 0에서 C가 되면 answer 증가
                answer++;
            }
        }
        System.out.println(answer);

    }

//2. 깊이 우선 탐색 함수
    //(r,c)위치에서 파이프 연결 시도
    static boolean dfs(int r, int c) { //현재위치 r,c
        //
        //2-1. 기저조건:c가 마지막 열 (C-1)도달시 true
        if (c == C - 1) {
            return true;
        }
        //2-2. 3방향 탐색 nr, cr 다음 위치
        for (int i = 0; i < 3; i++) {
            int nr = r + dr[i];     //static int[] dr = {-1, 0, 1};  우상, 우, 우하 우선순위 순서로 3방향 탐색
            int cr = c + 1;         //열은 오른쪽으로 1칸 직진(다음 행으로 이동이 됐다면)

            //2-3. nr이 행의 범위를 충족하고, 그 위치의 map이 . 이면 x로 방문처리 후
            if (nr >= 0 && nr < R && map[nr][cr] == '.') {
                map[nr][cr] = 'x';
                //다음칸으로 이동 (C-1)도달할때까지
                if (dfs(nr, cr)) {
                    //C-1까지 도달했다면 true로 확정짓는다.
                    return true;
                }
            }
        }
        //3방향 모두 막혔다면 false
        return false;

    }
}
