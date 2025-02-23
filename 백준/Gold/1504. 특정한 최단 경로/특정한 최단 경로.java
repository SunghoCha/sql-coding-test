


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static int[] dist;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(node).add(new Node(vertex, weight));
            graph.get(vertex).add(new Node(node, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long resultA = (long)dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        long resultB = (long)dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        long result = Math.min(resultA, resultB);

        if (result >= Integer.MAX_VALUE || result < 0) {
            sb.append(-1);
        } else {
            sb.append(result);
        }
        bw.write(sb.toString());
        bw.flush();

    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE); // 재사용을 위한 초기화
        // 거리가중치가 최소인 것들을 우선적으로 계산하기 위한 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>();
        // 시작노드 큐에 추가 (방문처리)
        queue.add(new Node(start, 0));
        // 시작노드까지의 거리는 0이다.
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int curVertex = node.getVertex();
            int curWeight = node.getWeight();

            if (curVertex == end) { // 목적지 방문한 상태면 이미 목적지까지의 최단거리 계산된 상태
                return dist[curVertex];
            }
            // 큐에서 가장 최단거리 가지는 노드꺼냈음. 이 노드와 이전노드간 최단거리 갱신 로직 수행해야함
            // curWeight만으로 현재까지 계산한 최단거리보다 크다면 더이상 로직 수행할 필요없으니 continue;
            if (curWeight > dist[curVertex]) { //dist[curVertex]가 있다는건 이미 계산 수행된적 있다는 뜻?
                continue;
            }

            for (Node next : graph.get(curVertex)) {
                int nextVertex = next.getVertex();
                int newWeight = curWeight + next.getWeight(); // nextVertex 노드까지의 누적거리

                if (newWeight < dist[nextVertex]) { // nextVertex까지의 거리보다 newWeight가 작다면 최단거리 갱신
                    dist[nextVertex] = newWeight; //
                    queue.add(new Node(nextVertex, newWeight));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}