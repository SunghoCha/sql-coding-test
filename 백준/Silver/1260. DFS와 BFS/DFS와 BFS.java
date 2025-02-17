


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static boolean[] visited;
    private static List<Integer> visitedOrder;
    private static List<Integer>[] neighbors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        // 초기화
        visitedOrder = new ArrayList<>();
        visited = new boolean[n + 1];
        neighbors = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        // 노드 연결
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            neighbors[node].add(value);
            neighbors[value].add(node); // 양방향
        }

        // 오름차순 정렬
        for (List<Integer> list : neighbors) {
            list.sort((a1, b1) -> a1 - b1);
        }

        dfs(a);
        for (Integer value : visitedOrder) {
            sb.append(value).append(" ");
        }

        sb.append("\n");
        resetGraph();

        bfs(a);
        for (Integer value : visitedOrder) {
            sb.append(value).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int start) {
        dfsRecursive(start);
    }

    private static void dfsRecursive(int start) {
        visited[start] = true;
        visitedOrder.add(start);

        for (Integer value : neighbors[start]) {
            if (!visited[value]) {
                dfsRecursive(value);
            }
        }
    }

    private static void resetGraph() {
        Arrays.fill(visited, false);
        visitedOrder.clear();
    }

    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        visitedOrder.add(start);

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            for (Integer value : neighbors[node]) {
                if (!visited[value]) {
                    deque.offer(value);
                    visited[value] = true;
                    visitedOrder.add(value);
                }
            }
        }
    }
}