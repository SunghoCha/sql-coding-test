import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        /*
            X, 1~9. X는 바다. 숫자는 무인도. 연결된 숫자는 하나로 취급
            각 칸의 숫자들은 식량 = 머물수있는 기간
            
            방문배열만들고 각 지점을 시작지점으로 해서 bfs돌려야할듯?
            X거나 visited면 바로 스킵하면서.
            bfs돌면 처음방문인건고, 이 때 식량누적해야함
            식량은 전역변수로 누적해도될듯? bfs끝나면 리스트에 추가.
            리스트 사이즈 0이면 -1를 배열에 담아 반환
        */
        int m = maps.length;
        int n = maps[0].length();
        char[][] board = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = chars[j];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X' && !visited[i][j]) {
                    int days = bfs(i, j, board, visited);
                    list.add(days);
                }   
            }
        }
        
        if (list.isEmpty()) {
            list.add(-1);
        }
        
        return list.stream()
            .sorted((a, b) -> a - b)
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public int bfs(int x, int y, char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = Character.getNumericValue(board[x][y]);
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (board[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        count += Character.getNumericValue(board[nx][ny]);
                        queue.offer(new int[]{nx, ny});
                        
                    }
                }
            }
        }
        return count;
    }
}