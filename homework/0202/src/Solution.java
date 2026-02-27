import java.io.*;
import java.util.*;

public class Solution {
    
    static class Point {
        int y, x;
        
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static int solveMaze(int[][] maze) {
        int n = 16;
        
        // 시작점(2)과 도착점(3) 찾기
        Point start = null;
        Point end = null;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 2) {
                    start = new Point(i, j);
                } else if (maze[i][j] == 3) {
                    end = new Point(i, j);
                }
            }
        }
        
        // 시작점이나 도착점이 없으면 0 반환
        if (start == null || end == null) {
            return 0;
        }
        
        // BFS를 이용한 경로 탐색
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        queue.offer(start);
        visited[start.y][start.x] = true;
        
        // 상하좌우 이동
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            // null 체크
            if (current == null) {
                continue;
            }
            
            // 도착점에 도달한 경우
            if (current.y == end.y && current.x == end.x) {
                return 1;
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                
                // 범위 체크 및 방문 여부 확인
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
                    // 벽(1)이 아닌 경우 이동 가능
                    if (maze[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
        }
        
        // 도착점에 도달하지 못한 경우
        return 0;
    }
    
    public static void main(String[] args) {
        // src 폴더 기준으로 상위 폴더의 res 폴더로 이동
        try (BufferedReader br = new BufferedReader(new FileReader("../res/d4_input.txt"))) {
            StringBuilder sb = new StringBuilder();
            
            String line;
            while ((line = br.readLine()) != null) {
                int tcNum = Integer.parseInt(line.trim());
                
                // 16x16 미로 읽기
                int[][] maze = new int[16][16];
                for (int i = 0; i < 16; i++) {
                    line = br.readLine();
                    if (line == null) break;
                    
                    for (int j = 0; j < 16; j++) {
                        maze[i][j] = line.charAt(j) - '0';
                    }
                }
                
                // 미로 탐색 및 결과 저장
                int result = solveMaze(maze);
                sb.append("#").append(tcNum).append(" ").append(result).append("\n");
            }
            
            // 결과 출력
            System.out.print(sb.toString());
            
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}