


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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int a = 1;

        // 초기화 작업
        visited = new boolean[n + 1];
        neighbors = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        // 노드 데이터 입력
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            neighbors[node].add(value);
            neighbors[value].add(node); // 양방향 그래프
        }

        // 너비우선탐색 수행
        bfs(a);

        // 방문된 노드 카운트
        int count = 0;
        for (int i = 2; i <= n; i++) { // 1번 노드 제외이므로 2번부터 시작
            if (visited[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();

    }

    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            for (Integer value : neighbors[node]) {
                if (!visited[value]) {
                    deque.offer(value);
                    visited[value] = true;
                }
            }
        }
    }
}