


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static int[][] input;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        input = new int[n][n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    result.add(size);
                }
            }
        }
        result.sort((a1, b1) -> a1 - b1);
        sb.append(result.size()).append("\n");
        for (Integer value : result) {
            sb.append(value).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int dfs(int x, int y) {
        int count = 1;
        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValidPosition(nx, ny) && !visited[nx][ny] && input[nx][ny] == 1) {
                count += dfs(nx, ny);
            }
        }

        return count;
    }

    private static boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}