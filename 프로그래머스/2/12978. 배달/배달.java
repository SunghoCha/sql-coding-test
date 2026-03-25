import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        /*
            현재 노드에서 방문가능한 노드를 우선순위 큐에 넣음
            노드에는  노드번호와 해당 노드까지의 비용정보.
            근데 노드에 접근하는 비용이 더 작을떄만 해당 노드 업데이트?
            이건 방문배열이 없어야하나?
            기억에는 최초방문이 가장 최단거리라서 방문배열이 있어야했던걸로?
            그러면 방문배열있으니 해당 노드 업데이트는 한 번만 이라서 min체크없어도될듯
            (최초방문이 왜 가장 최단거리인지 증명할것)
            node(노드번호, 여기까지오는 비용)
        */
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // 0,1 ~ N
            adj.add(new ArrayList<>());
        }
        for (int[] arr : road) {
            int u = arr[0];
            int v = arr[1];
            int weight = arr[2];
            adj.get(u).add(new Node(v, weight));
            adj.get(v).add(new Node(u, weight));
        } 
        
        PriorityQueue<Node> pri = new PriorityQueue<>((a, b) -> {
            return a.dis - b.dis;
        });
        pri.offer(new Node(1, 0)); // 첫 시작노드 담기
        int[] dist = new int[N + 1]; // 0, 1 ~ N
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE; // 최단거리 배열
        }
        dist[1] = 0;
        while(!pri.isEmpty()) {
            Node cur = pri.poll();
            if (cur.dis > dist[cur.num]) continue;
            for (Node node :adj.get(cur.num)) {
                int newDis = node.dis + cur.dis;
                if (dist[node.num] > newDis) {
                    dist[node.num] = newDis;
                    pri.offer(new Node(node.num, newDis));
                }
                
            }
        }
        
        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }
    
    public static class Node {
        int num;
        int dis;
        
        Node(int n, int d) {
            this.num = n;
            this.dis = d;
        }
    }
}