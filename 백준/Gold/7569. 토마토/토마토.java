import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H;
    static int[][][] box;
    static int[][][] days;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Point {
        int x, y, z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        days = new int[H][N][M];

        Queue<Point> queue = new LinkedList<>();
        boolean allRipe = true;

        // 입력 처리 (H -> N -> M 순서)
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.add(new Point(m, n, h)); // 익은 토마토 위치
                    } else if (box[h][n][m] == 0) {
                        allRipe = false; // 익지 않은 토마토가 있는 경우
                    }
                }
            }
        }

        // 모든 토마토가 이미 익어있는 경우
        if (allRipe) {
            System.out.println(0);
            return;
        }

        // BFS 실행
        int result = bfs(queue);

        // BFS 종료 후 익지 않은 토마토 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) { // 익지 않은 토마토가 남아있으면
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(Queue<Point> queue) {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x, y = p.y, z = p.z;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;  // 익게 만들고
                        days[nz][ny][nx] = days[z][y][x] + 1; // 날짜 증가
                        maxDays = Math.max(maxDays, days[nz][ny][nx]);
                        queue.add(new Point(nx, ny, nz));
                    }
                }
            }
        }
        return maxDays;
    }
}
