


import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static boolean[][] visited;
    private static int[][] input;
    private static int size;
    private static int width;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        input = new int[height][width];
        visited = new boolean[height][width];

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (input[i][j] == 1) {
                    deque.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int result = bfs(deque);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (input[i][j] == 0) {
                    result = - 1;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }

    private static int bfs(Deque<int[]> deque) {
        int count = -1;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        while (!deque.isEmpty()) {
            int total = deque.size();
            for (int i = 0; i < total; i++) {
                int[] node = deque.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = node[0] + dx[j];
                    int ny = node[1] + dy[j];

                    if (isValidPosition(nx, ny) && !visited[nx][ny] && input[nx][ny] == 0) {
                        deque.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        input[nx][ny] = 1;
                    }
                }
            }
            count++;
        }
        return count;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

}