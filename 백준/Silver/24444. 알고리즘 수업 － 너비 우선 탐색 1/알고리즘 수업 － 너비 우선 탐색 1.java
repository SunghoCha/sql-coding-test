


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static Map<Integer, List<Integer>> map;
    private static boolean[] visited;
    private static int[] visitedOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        // 노드 초기화
        map = new HashMap<>();
        visited = new boolean[n + 1];
        visitedOrder = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        // 간선 연결
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(node).add(value);
            map.get(value).add(node); // 양방향 그래프
        }

        for (Integer key : map.keySet()) {
            map.get(key).sort((a1, a2) -> a1 - a2);
        }

        bfs(a);

        for (int i = 1; i <= n; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void bfs(int start) {
        int order = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        visitedOrder[start] = order++;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            for (Integer neighbor : map.get(node)) {
                if (!visited[neighbor]) {
                    deque.offer(neighbor);
                    visited[neighbor] = true;
                    visitedOrder[neighbor] = order++;
                }
            }
        }
    }
}