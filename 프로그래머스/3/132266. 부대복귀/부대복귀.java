import java.util.*;
class Solution {
      
    int n = 0;
    int destination = 0;
    List<List<Integer>> adj = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
            
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        this.destination = destination;
        
        
            
        /*
            두 지역 간의 길을 통과하는데 걸리는 시간은 모두 1로 동일
            최단시간 부대복귀. 돌아오는 경로 없어져서 복귀불가능한 경우도 있음? 그냥 -1리턴하라는뜻
            각 부대원들이 최단시간복귀하는 배열 반환.
            destinatnion으로 복귀
            
            각 소스에 대해 bfs돌리면 될 듯. 독립적임
            양방향 인접리스트 필요. 인접리스트는 공통
            거리계산 dist필요. dist는 bfs마다 초기화
        */
        
        for (int i = 0; i <= n; i++) { // 0,1, .. n
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            bfs(source, i);
        } 
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
       
        return answer;
    }
    
    public void bfs(int source, int idx) {
        int[] dist = new int[n + 1]; // 0,1, .. n  
        Arrays.fill(dist, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        dist[source] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            // 여기서 체크해야함 시작지점이 바로 가능하기 때문. idx 정보 수정해야함
            // queue 자체가 idx를 담은 int[]로 idx정보를 담아야하는가?
            // 아니면 외부에서 별도로 추적가능한지 따져보기
            // 아니면 애초에 List로 add하고 나중에 변환은?
            // while문에서 찾으면 추가후 바로 리턴
            // 못찾으면 while문끝나고 -1추가한후 리턴
            if (cur == destination) { 
                list.add(dist[cur]);  
                return;
            }
            
            for (int next : adj.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
        list.add(-1);
        return;
    }
}