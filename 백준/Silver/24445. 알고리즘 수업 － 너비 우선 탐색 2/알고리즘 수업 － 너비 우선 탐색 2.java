


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int[] visitedOrder;
    private static List<Integer>[] neighbors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        visitedOrder = new int[n + 1];
        neighbors = new ArrayList[n + 1];
        // 초기화
        for (int i = 0; i <= n; i ++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            neighbors[node].add(value);
            neighbors[value].add(node); // 양방향 그래프
        }

        // 내림차순
        for (List<Integer> list : neighbors) {
            list.sort((a1, b1) -> b1 - a1);
        }

        bfs(a);

        for (int i = 1; i <= n; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int start) {
        int order = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        visitedOrder[start] = order++;

        while (!deque.isEmpty()) {
            int node = deque.poll();
            for (Integer neighbor : neighbors[node]) {
                if (!visited[neighbor]) {
                    deque.offer(neighbor);
                    visited[neighbor] = true;
                    visitedOrder[neighbor] = order++;
                }
            }
        }
    }
}