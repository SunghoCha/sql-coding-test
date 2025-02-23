import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
    static int N, E;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    
    // Dijkstra 알고리즘: 시작 정점부터 모든 정점까지의 최단 거리를 구함
    public static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curVertex = cur.vertex;
            int curWeight = cur.weight;
            
            // 이미 더 짧은 경로가 발견된 경우 건너뜀
            if (curWeight > dist[curVertex]) continue;
            
            // 현재 정점의 인접 노드를 확인하며 최단 거리 갱신
            for (Node next : graph.get(curVertex)) {
                int nextVertex = next.vertex;
                int newWeight = curWeight + next.weight;
                if (newWeight < dist[nextVertex]) {
                    dist[nextVertex] = newWeight;
                    pq.offer(new Node(nextVertex, newWeight));
                }
            }
        }
        return dist;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화 (정점 번호는 1부터 N까지 사용)
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 양방향 간선 추가
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        // 반드시 거쳐야 하는 두 정점 v1과 v2
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        // 1번, v1, v2에서 각각의 최단 거리 배열 구하기
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);
        
        // 경로 1: 1 → v1 → v2 → N
        long route1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        // 경로 2: 1 → v2 → v1 → N
        long route2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];
        
        long result = Math.min(route1, route2);
        
        // 경로가 존재하지 않으면 -1 출력
        if (result >= INF || result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
