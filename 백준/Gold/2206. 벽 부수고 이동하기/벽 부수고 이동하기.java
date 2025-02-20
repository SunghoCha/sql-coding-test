import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] input;
    private static int[][][] distance; // distance[y][x][broken]
    
    // 이동 방향: 상, 하, 좌, 우
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        input = new int[N][M];
        distance = new int[N][M][2]; // 0: 벽을 부수지 않은 상태, 1: 벽을 부순 상태
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // 각 문자 '0' 또는 '1'을 정수로 변환
                input[i][j] = line.charAt(j) - '0';
            }
        }
        
        int result = bfs(0, 0);
        System.out.println(result);
    }
    
    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        // 노드 상태: {y, x, broken} 
        // broken: 0이면 아직 벽을 부수지 않은 상태, 1이면 벽을 부순 상태
        queue.offer(new int[]{startY, startX, 0});
        distance[startY][startX][0] = 1;  // 시작점은 거리 1
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1], broken = cur[2];
            
            // 도착점에 도달하면 해당 거리 반환
            if (y == N - 1 && x == M - 1) {
                return distance[y][x][broken];
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                // 맵 범위 체크
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                
                // 다음 칸이 이동 가능(빈 칸, input==0)인 경우
                if (input[ny][nx] == 0 && distance[ny][nx][broken] == 0) {
                    distance[ny][nx][broken] = distance[y][x][broken] + 1;
                    queue.offer(new int[]{ny, nx, broken});
                }
                // 다음 칸이 벽( input==1 )이고 아직 벽을 부수지 않은 상태(broken==0)인 경우
                if (input[ny][nx] == 1 && broken == 0 && distance[ny][nx][1] == 0) {
                    distance[ny][nx][1] = distance[y][x][broken] + 1;
                    queue.offer(new int[]{ny, nx, 1});
                }
            }
        }
        
        // 도착점에 도달하지 못한 경우 -1 반환
        return -1;
    }
}
