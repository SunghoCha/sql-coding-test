


import java.util.*;
import java.io.*;

public class Main {
    
    private static StringBuilder sb;
    private static boolean[][] visited;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            size = Integer.parseInt(br.readLine());
            visited = new boolean[size][size];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = bfs(x1, y1, x2, y2);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

    }

    private static int bfs(int x1, int y1, int x2, int y2) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{x1, y1});
        visited[x1][y1] = true;
        int count = 0;

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] node = deque.poll();

                if (node[0] == x2 && node[1] == y2) {
                    return count;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = node[0] + dx[j];
                    int ny = node[1] + dy[j];

                    if (isValidPosition(nx, ny) && !visited[nx][ny]) {
                        deque.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

        private static boolean isValidPosition ( int x, int y){
            return x >= 0 && x < size && y >= 0 && y < size;
        }


    }