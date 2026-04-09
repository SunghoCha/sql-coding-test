import java.util.*;
class Solution {
    int[] costS;
    int[] costA;
    int[] costB;
    int n = 0;
    List<List<int[]>> adj = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        this.costS = new int[n + 1];
        this.costA = new int[n + 1];
        this.costB = new int[n + 1];
        /*
            지점의 개수n, 출발지점s, A도착지점a, B도착지점B
            s에서 출발해서 a,b에 도착할때 최저요금 반환
            합승을 얼마나 할것인가가 핵심
            합승지점을 찾으면, 거기서 2개의 다익스트라알고리즘 전개
            합승지점을 어떻게 정의할 것인가?
            둘이 합승하는 것이 더 이득인 지점까지 합승한다.
            근데생각해보면 s에서 a,b로 가는 다익스트라릉 전개할떄 겹치는 경로만큼 합승하는거 아닌가?
            그런데 전개 되는 다익스트라 중에 이걸 어떻게 잡아내지?
            근데 이 합승지점을 꼭 명시적으로 잡아내고 여기서 다시 2개의 다익스트라를 전개해야하나? 
            이게 아닐수도?
            그냥 a 다익스트라를 먼저 전개하고 특정 상태를 마크해놓기
            아니면 특정상태가 아니라 비용자체를 0으로 바꾼다고 생각하면 안되나?
            첫번째 다익스트라하면서 비용을 어떻게 바꾸지?     
            
            리뷰받음
            이 방향성 자체가 틀림. 예를 들어 애초에 b가 a와 겹치는 부분이 없다고치자.
            그런데 a가 자신의 경로 비용을 0으로 바꾸면 b도 시작부터 여기로 이동하면서 달라짐
            
            그냥 구간을 s -> k / k -> a / k -> b로 나누고 다합한것의 최소값 구하기
            여기서 하나 또 중요한 아이디어는 k -> a와 a -> k가 같다는것.
            s -> k / a -> k / b -> k/ 를 구하는 문제
            s,a,b에서 다익스트라르 전개하면 각 노드들로의 최단 비용이 나옴
            모든 k에 대해 합을 구하고 이 중에서 최소값 구하는 문제가 됨
        */
        
        
        for (int i = 0; i <= n; i++) { // 0, 1, ... n
            adj.add(new ArrayList<>());
        }
        for (int[] fare : fares) { // 양방향
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            adj.get(u).add(new int[]{v, cost});
            adj.get(v).add(new int[]{u, cost});
        }
        
        /*
            s,a,b에서의 다익스트라를 수행하고 각 노드의 비용정보가 필요함
            int[] costS, costA, costB
        */
        costS = dijk(s);
        costA = dijk(a);
        costB = dijk(b);
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int result = costS[i] + costA[i] + costB[i];
            min = Math.min(min, result);
        }
        
        return min;
    }
    
    
    public int[] dijk(int start) {
        PriorityQueue<int[]> pri = new PriorityQueue<>((a, b) -> { // 비용작은걸 우선
            return a[1] - b[1];
        });
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pri.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while (!pri.isEmpty()) {
            int[] cur = pri.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if (cost > dist[node]) {
                continue;
            }
            
            for (int[] next : adj.get(node)) {
                int nextNode = next[0];
                int newCost = cost + next[1];
                if (newCost < dist[nextNode]) {
                    pri.offer(new int[]{nextNode, newCost});
                    dist[nextNode] = newCost;
                }
            }
        } 
        return dist;
    }
}