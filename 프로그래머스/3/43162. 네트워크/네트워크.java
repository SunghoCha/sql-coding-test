import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = i + 1; j < computers.length; j++) {
                if (computers[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
                    
            }
        }
        // 연결정보 다 구했으면 bfs돌려서 몇 개의 네트워크인지 찾음
        int answer = 0;
        boolean[] visited = new boolean[n]; // 0 ~ n - 1. 전체 공유 방문배열
        for (int i = 0; i < n; i++) {    
            if (!visited[i]) { // 첫 시작지점은 바깥에서 체크
                answer += bfs(adj, visited, i); // 컴퓨터는 0 ~ n -1
            }
        }
        
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> adj, boolean[] visited, int start) {
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
                        
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return 1;
    }
}