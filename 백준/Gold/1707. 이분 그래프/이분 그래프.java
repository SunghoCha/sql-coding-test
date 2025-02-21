


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static Map<Integer, List<Integer>> map;
    private static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int total = 0; total < K; total++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for (int i = 1; i <= V; i++) {
                map.put(i, new ArrayList<>());
            }
            color = new int[V + 1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                map.get(node).add(value);
                // 양방향? 단방향? 별로 상관없으려나
                map.get(value).add(node);
            }

            boolean isTrue = dfs(map, color);

            sb.append(isTrue ? "YES" : "NO").append("\n");


        }

        bw.write(sb.toString());
        bw.flush();


    }

    private static boolean dfs(Map<Integer, List<Integer>> map, int[] color) {
        boolean isBiGraph = true;
        for (Integer value : map.keySet()) {
            if (color[value] == 0) {
               if (!dfsRecursive(value, 1)) {
                    isBiGraph = false;
                    break;
               };
            }
        }
        return isBiGraph;
    }

    private static boolean dfsRecursive(Integer start, int c) {
        color[start] = c;
        for (Integer value : map.get(start)) {
            if (color[value] == 0) {
                if (!dfsRecursive(value, -c)) {
                    return false;
                };
            } else if (color[value] == c ) {
                return false;
            }
        }
        return true;
    }
}