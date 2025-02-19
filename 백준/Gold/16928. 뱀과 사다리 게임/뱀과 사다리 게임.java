


import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static Map<Integer, Integer> map;
    private static int[] input;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        map = new HashMap<>();
        visited = new boolean[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int result = bfs(1, deque);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int bfs(int start, Deque<Integer> deque) {
        deque.offer(start);
        visited[start] = true;
        int[] dx = {1, 2, 3, 4, 5, 6};
        int count = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Integer node = deque.poll();

                if (node == 100) {
                    return count;
                }
                for (int j = 0; j < 6; j++) {
                    int nx = node + dx[j];
                    if (map.containsKey(nx)) {
                        nx = map.get(nx);
                    }
                    if (isValidPosition(nx) && !visited[nx]) {
                        deque.offer(nx);
                        visited[nx] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static boolean isValidPosition(int x) {
        return x >= 0 && x <= 100;
    }
}