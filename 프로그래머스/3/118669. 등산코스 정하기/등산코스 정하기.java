import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        /*
          출입구 쉼터 산봉우리
          쉼터, 산봉우리 방문할떄마다 휴식취할수있음
          휴식없이 이동해야하는 시간 중 가장 긴 시간을 코스의 intensity라고 함
          출입구는 처음과 끝. 산봉우리는 한번만 포함. 원래출입구로 돌아와야함
          inten 최소화하는 동선
          어떤 노드든 방문마다 휴식. 그러므로 제대로 된 코스 중 가장 코스트높은것이 바로 inten
          코스자체의 최소시간을 구하는것이 아님에 유의
          intensity가 최소가 되는 등산코스가 여러 개라면 그중 산봉우리의 번호가 가장 낮은 등산코스를 선택
          출입구 gates / 산봉우리 summits / paths 경로들
          paths들로 인접리스트 구성.
          출입구들에서 각각 bfs함 매번 노드마다 해당출입구나 다른출입구 체크.
          산봉우리 한 번 지나야함. 이건 boolean으로 할까? 한 번 지났으면 플래그세우고 체크?
          그리고 bfs마다의 최소거리 기억해놔야함 이건 전역변수관리 불가능이고..
          이 문제는 근데 다익스트라? 애초에 최소비용으로 가는것도 아닌데굳이?
          그냥 bfs로하면서 해당 bfs경로에서의 최소거리 기억을 해야하는데..
          
          근데 생각해보면그냥 출입구 - 산봉우리, 산봉우리 - 출입구로 가는 2개의 bfs아닌가?
          그럴필요도없음 그냥 출입구 - 산봉우리로 가는 다익스트라. 
          다른출입구체크, 산봉우리도착하면 끝, 그리고 노드에 매번 노드간최장거리 상태로 가져야함
          
        */
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 초기화
            adj.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int cost = path[2];
            adj.get(u).add(new int[]{v, cost});
            adj.get(v).add(new int[]{u, cost});
        }
    
        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }
        
        PriorityQueue<int[]> pri = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1]; // 비용 작은걸 우선
        });
        int[] inten = new int[n + 1];
        Arrays.fill(inten, Integer.MAX_VALUE);
        Set<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            pri.offer(new int[]{gate, 0});
            gateSet.add(gate);
            inten[gate] = 0;
        }
        
        while (!pri.isEmpty()) {
            int[] cur = pri.poll();
            int curNum = cur[0];
            int curCost = cur[1];
            if (curCost > inten[curNum]) continue;
            if (summitSet.contains(curNum)) continue;
            /*
                gate포함하면 안됨
                산봉우리면 종료
            */
            for (int[] next : adj.get(curNum)) {
                int nextNum = next[0];
                int nextCost = next[1];
                if (gateSet.contains(nextNum)) {
                    continue;
                }
                int newInten = Math.max(curCost, nextCost);
                if (newInten < inten[nextNum]) {
                    inten[nextNum] = newInten;
                    pri.offer(new int[]{nextNum, newInten});
                }

            }
        }
        
        int[] answer = {};
        int min = Integer.MAX_VALUE;
        Arrays.sort(summits);
        int summitNum = -1;
        for (int summit : summits) {
            if (inten[summit] < min) {
                min = inten[summit];
                summitNum = summit;
            }    
        }
        
        return new int[]{summitNum, min};
    }
}