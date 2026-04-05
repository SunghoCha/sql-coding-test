import java.util.*;
class Solution {
    public int[] parent;
    public int solution(int n, int[][] costs) {
        /*
            n은 100개 이하. costs 길이 ~n^2
            유니온파인드?
        
        */
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            if (find(from) != find(to)) {
                union(from, to);
                sum += cost;
            }
            
        }
        
        return sum;
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);    
        }
        return parent[x];
    }
    
    public void union(int a, int b) {
        parent[find(a)] = find(b); // a의 root를 b로.
    }
}