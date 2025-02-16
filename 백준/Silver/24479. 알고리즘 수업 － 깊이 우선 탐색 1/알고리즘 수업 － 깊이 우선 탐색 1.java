


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int[] visitedOrder;
    private static Map<Integer, List<Integer>> map;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        visited = new boolean[n + 1];
        visitedOrder = new int[n + 1];
        visitedOrder[a] = 1;

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(node).add(value);
            map.get(value).add(node);
        }
        for (Integer key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        dfs(a);

        for (int i = 1; i <= n; i++) {
            sb.append(visitedOrder[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {
        Arrays.fill(visited, false);
        dfsRecursive(start);
    }

    private static void dfsRecursive(int start) {
        visited[start] = true;
        visitedOrder[start] = count++;
        for (Integer value : map.get(start)) {
            if (!visited[value]) {
                dfsRecursive(value);
            }
        }
    }


}
