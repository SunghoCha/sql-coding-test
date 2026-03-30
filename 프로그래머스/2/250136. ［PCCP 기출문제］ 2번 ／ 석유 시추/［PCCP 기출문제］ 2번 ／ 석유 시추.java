import java.util.*;
class Solution {
    int n = 0;
    int m = 0;
    
    public int solution(int[][] land) {
        
        /*
            m * n * m으로 시간초과판정받음
            bfs돌면서 col마다의 석유개수 카운팅하는 배열     
            근데 col마다 찾는것도 아니고 뭐지 이렇게 하면 안되는데
        */
        n = land.length;
        m = land[0].length;
        int[] arr = new int[m]; // 0 ~ m - 1
        boolean[][] visited = new boolean[n][m];
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {                    
                    Info info = bfs(land, visited, i, j);        
                    infos.add(info);
                }               
            }
        }
        // 덩어리마다의 컬럼정보가 있음
        // info의 set에 있는 컬럼에 대해서 count만큼 추가
        int[] ans = new int[m];
        for (Info info : infos) {
            for (int idx : info.set) {
                ans[idx] += info.count;
            }    
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > max) {
                max = ans[i];
            }
        }
        return max;   
    }
    
    public Info bfs(int[][] land, boolean[][] visited, int x, int y) {
        Set<Integer> set = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        set.add(y);
        
        int count = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                   && !visited[nx][ny] && land[nx][ny] == 1) {
                    count++;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    set.add(ny);
                    
                }
            }
        }
        return new Info(count, set);
    }
    
    public static class Info {
        int count;
        Set<Integer> set = new HashSet<>();
        
        Info(int count, Set<Integer> set) {
            this.count = count;
            this.set = set;
        }
    }
}





// import java.util.*;
// class Solution {
//     int n = 0;
//     int m = 0;
//     public int solution(int[][] land) {
//         /*
//             해당 col마다 bfs수행하고 합산해야하는데..
//             col마다 방문배열을 따로 써야함.
//             그리고 방문하지않은 석유면 bfs시작
            
//         */
//         n = land.length;
//         m = land[0].length;
        
//         int max = Integer.MIN_VALUE;
//         for (int j = 0; j < m; j++) { // 해당 col에 대해서 bfs수행
//             boolean[][] visited = new boolean[n][m];   
//             int ans = 0;
//             for (int i = 0; i < n; i++) {
//                 if (!visited[i][j] && land[i][j] == 1) {
//                     ans += bfs(land, visited, i, j);  
//                 }
//             }
//             max = Math.max(max, ans);
//         }
       
//         return max;
//     }
    
//     public int bfs(int[][] land, boolean[][] visited, int x, int y) {
//         Deque<int[]> queue = new ArrayDeque<>();
//         int[] dx = {-1, 1, 0, 0};
//         int[] dy = {0, 0, -1, 1};
//         queue.offer(new int[]{x, y});
//         visited[x][y] = true;
//         int count = 1;
//         while (!queue.isEmpty()) {
//             int[] cur = queue.poll();
//             int curX = cur[0];
//             int curY = cur[1];
//             for (int i = 0; i < 4; i++) {
//                 int nx = curX + dx[i];
//                 int ny = curY + dy[i];
                
//                 if (nx >= 0 && nx < n && ny >= 0 && ny < m 
//                     && !visited[nx][ny] && land[nx][ny] == 1) {
//                     visited[nx][ny] = true;
//                     queue.offer(new int[]{nx, ny});
//                     count++;
//                 }
//             }
//         }
       
//         return count;
//     }
// }