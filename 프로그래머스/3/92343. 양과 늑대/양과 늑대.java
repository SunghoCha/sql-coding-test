import java.util.*;
class Solution {
    int n = 0;
    int max = Integer.MIN_VALUE;
    int[] info;
    List<List<Integer>> adj = new ArrayList<>();
    public int solution(int[] info, int[][] edges) {
        this.n = info.length;
        this.info = info;
        /*
            노드 방문할때마다 양,늑대수 카운팅됨
            늑대수가 양 이상이 되는순간 양이 다 잡아먹힘
            항상 양의 수가 늑대보다 많게 유지하면서 최대한 많은 수의 양을 모아서 다시 루트 노드로 복귀
            루트노드에는 항상 양 1마리 있음
            
            양 또는 늑대에 대한 정보가 담긴 info 길이 최대 17
            노드에 0이면 양, 1이면 늑대
            edge 길이 최대 16. 간선정보
            
            재귀나 순회문제가 아닌거같은데 맞나?
            좌우를 조건에 맞게 움직이는 형태?
            크기자체는 작아서 완탐으로도 될거같은데 그 완탐은 어떻게 구성해야하는지도 감이 안 옴
        */
        
        
        for (int i = 0; i < n; i++) { // 0번부터 시작하는 노드. 0 .. n-1
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) { // 단방향. 부모 -> 자식
            adj.get(edge[0]).add(edge[1]);
        }
        List<Integer> nodes = new ArrayList<>(adj.get(0));
        dfs(1, 0, nodes);
        
        
        return max;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> nodes) {
        max = Math.max(max, sheep);
        
        for (int i = 0; i < nodes.size(); i++) {
            int next = nodes.get(i);
            int newSheep = sheep;
            int newWolf = wolf;
            if (info[next] == 0) {
                newSheep++;        
            } else {
                newWolf++;
            }
            
            if (newSheep <= newWolf) { // 지금 당장은 방문 불가
                continue;
            }
            // 양이 더 많아서 방문가능. 
            List<Integer> newNodes = new ArrayList<>(nodes);
            newNodes.remove(i); // 현재 방문 노드 제거
            newNodes.addAll(adj.get(next));
            dfs(newSheep, newWolf, newNodes);
        }
    }
}