import java.util.*;
class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    int[][] dp;
    public int solution(int n, int[][] light) {
        
        /*
            n이 10만. 간선의 개수가 n-1 이라는게 힌트인가?
            10만개면 .. dfs 불가능. 2^n?
            애초에 완탐으로 생각한건 모든 선택,탐색을 독립적으로 가정했기 때문
            하지만 이 문제는 모든 탐색이 선택이 독립적이지 않음
            일단 이 문제가 간선개수가 n-1개이고 사이클이 없는 트리구조라는게 핵심
            사이클이 없어서 의존관계가 단방향이라 명확함.
            단방향이면서 서브트리구조이면 부분최적해가 사이클이없고 
            작은 최적해부터 확정정으로 정할 수 있다는 의미
            트리에서는 자식서브트리가 이에해당. 리프부터 올라오면서 완성되는 구조.
            작은 최적해부터 확정해나갈수 있다는 의미
            그렇다면 dp는 어떻게 정의되어야하는지?
            dp : v노드까지의 최소 개수
            1차원으로 가능한가?
            v노드가 켜져있는지 아닌지에 따라 미래에 영향을 주기 때문에 상태분리해야할듯
            dp[v][0], dp[v][1]
            여기서 주어진 트리는 루트를 지정하지않은 무루트 트리이므로 아무곳에서 시작해도 가능
            다시 되돌아가지않게 방문배열을 두거나 해당 dfs에서 처리한 노드를 전달해서 parent로
            인식하게해서 parent면 스킵하도록 처리
        */
        dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) { // 0, 1,.. n
            adj.add(new ArrayList<>());
        }
        for (int[] lh : light) {
            int v = lh[0];    
            int u = lh[1];
            adj.get(v).add(u); //누가 부모인지 모르니 일단 양방향 연결하고 중복방문 막기
            adj.get(u).add(v);
        }
        int root = light[0][0];
        dfs(root , -1); // -1은 parent 의미. 루트니까 없음 그래서 -1
        
               
        
        return Math.min(dp[root][0], dp[root][1]);
    }
    
    public void dfs(int v, int parent) {
        dp[v][0] = 0;
        dp[v][1] = 1;
        
        for (int next : adj.get(v)) {
            if (next == parent) continue;
            dfs(next, v);
            
            dp[v][0] += dp[next][1];
            dp[v][1] += Math.min(dp[next][0], dp[next][1]);
        }
        
    }
}