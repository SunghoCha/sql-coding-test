import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int[][] input;
    private static boolean[][] visited;
    private static int width;  // 가로
    private static int height; // 세로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int num = 0; num < total; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());  // M (가로)
            height = Integer.parseInt(st.nextToken()); // N (세로)
            int k = Integer.parseInt(st.nextToken());  // 배추 개수

            // ✅ 배열 선언 순서 수정 (height x width)
            input = new int[height][width];
            visited = new boolean[height][width];

            // 배추 위치 입력
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()); // 가로(x)
                int x = Integer.parseInt(st.nextToken()); // 세로(y)
                input[x][y] = 1; // (세로, 가로) 좌표로 저장
            }

            int count = 0; // 필요한 지렁이 개수
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && input[i][j] == 1) {
                        bfs(i, j); // BFS 탐색 시작
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {1, -1, 0, 0}; // 상하
        int[] dy = {0, 0, 1, -1}; // 좌우

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curX = node[0], curY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (isValidPosition(nx, ny) && !visited[nx][ny] && input[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // ✅ x, y 범위 체크 수정
    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }
}
