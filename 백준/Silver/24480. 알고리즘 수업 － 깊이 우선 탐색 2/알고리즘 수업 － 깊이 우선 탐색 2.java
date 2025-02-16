

import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static Map<Integer, List<Integer>> map;
    private static boolean[] visited;
    private static int[] visitedOrder;
    private static int count = 0;

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
        map = new HashMap();

        // map 초기화
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(node).add(value);
            map.get(value).add(node); // 양방향 그래프
        }

        // 노드 내림차순 정렬
        for (Integer key: map.keySet()) {
            map.get(key).sort((a1, a2) -> a2 - a1);
        }

        dfs(a);

        for (int i = 1; i <= n; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void dfs(int startNode) {
        Arrays.fill(visited, false);
        dfsRecursive(startNode);
    }

    public static void dfsRecursive(int startNode) {
        visited[startNode] = true;
        visitedOrder[startNode] = ++count;
        for (Integer node : map.get(startNode))
            if (!visited[node]) {
                dfsRecursive(node);
            }
    }
}