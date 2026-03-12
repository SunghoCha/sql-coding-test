import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        /*
            1,1 -> n,m = 0,0 -> n-1, m-1 인덱스 기반
            bfs
        */
        Deque<int[]> queue = new ArrayDeque<>();
        int n = maps.length; // 0 ~ n - 1
        int m = maps[0].length; // 0 ~ m - 1
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{0, 0, 1}); 
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == n - 1 && y == m - 1) {
                return dist;    
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) { // n-1, m-1 인덱스
                    if (!visited[newX][newY] && maps[newX][newY] != 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY, dist + 1});
                    }
                }
            }
        }
        return answer;
    }
}