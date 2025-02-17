


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int[][] input;
    private static boolean[][] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        for (int num = 0; num < total; num++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            input = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                input[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && input[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidPosition(nx, ny) && !visited[nx][ny] && input[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}