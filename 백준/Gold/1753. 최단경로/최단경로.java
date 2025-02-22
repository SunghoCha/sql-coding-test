import java.io.*;
import java.util.*;

public class Main {
    // 각 정점을 나타내는 Node 클래스 (우선순위 큐 정렬을 위해 Comparable 구현)
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 및 출력을 위한 BufferedReader, BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수(V)와 간선의 개수(E) 입력
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 시작 정점 K 입력
        int start = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화 (정점 번호는 1부터 V까지)
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // E개의 간선 정보를 입력 받아 그래프 구성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        // 최단 경로를 저장할 배열 (무한대를 Integer.MAX_VALUE로 설정)
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 우선순위 큐를 사용하여 Dijkstra 알고리즘 수행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            // 이미 더 짧은 경로가 발견되었다면 건너뛰기
            if (curWeight > dist[curVertex]) continue;

            // 현재 정점과 인접한 모든 정점에 대해
            for (Node neighbor : graph[curVertex]) {
                if (dist[neighbor.vertex] > curWeight + neighbor.weight) {
                    dist[neighbor.vertex] = curWeight + neighbor.weight;
                    pq.offer(new Node(neighbor.vertex, dist[neighbor.vertex]));
                }
            }
        }

        // 결과 출력: 경로가 없으면 "INF" 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
