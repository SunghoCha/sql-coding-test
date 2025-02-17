


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int[][] input;
    private static boolean[][] visited;
    private static int width;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        input = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                input[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);

        bw.write(String.valueOf(result));
        bw.flush();

    }

    private static int bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!deque.isEmpty()) {
            int[] node = deque.poll();

            if (isTarget(node[0], node[1])) {
                return input[node[0]][node[1]];
            }

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if (isValidPosition(nx, ny) && !visited[nx][ny] && input[nx][ny] == 1) {
                   deque.offer(new int[]{nx, ny});
                   visited[nx][ny] = true;
                   input[nx][ny] = input[node[0]][node[1]] + 1;
                }
            }
        }
        return input[height - 1][width - 1];
    }

    private static boolean isTarget(int x, int y) {
        return x == height - 1 && y == width - 1;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }
}