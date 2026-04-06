import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        /*
            끝나기전까진 가장 멀리떨어진 거리를 알 수 없음
            노드마다 1과의 거리를 기록해놔야함
            노드를 식별하기 위한 인덱스(1-base라 주의), 1과의 거리 dist
            int[]로 표현?
            최단거리 개념이므로 노드 방문 1번만 허용해도 될 듯?
            
            노드의개수 2만, 간선은 5만
            인접리스트 필요한가? 하는게 좋을듯
            시작지점은 1번노드.
            거리개념은 방문배열과 합쳐서 표현 dist[] 처음엔 -1로 초기화
        */
        List<List<Integer>> adj = new ArrayList<>(); // 0,1 .. n
        for (int i = 0; i <= n; i++) { // 초기화 0,1, .. n까지
            adj.add(new ArrayList<>());
        }
        for (int[] ver : edge) {
            int u = ver[0];
            int v = ver[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dist = new int[n + 1]; // 0, 1 .. n
        Arrays.fill(dist, -1); // 시작노드는 0이라서 -1하고 의무구분해야함
        bfs(1, adj, dist); // 1번노드 시작
        
        int maxDist = 0;
        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                count = 1;
            } else if (dist[i] == maxDist) {
                count++;
            }
        }
        
       
        return count;
    }
    
    public void bfs(int start, List<List<Integer>> adj, int[] dist) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int next : adj.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }

    }
    
}