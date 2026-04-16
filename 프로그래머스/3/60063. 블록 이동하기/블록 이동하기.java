import java.util.*;
class Solution {
    boolean[][][] visited;
    int n = 0;
    int[][] board;
    int[][][] dist;
    
    public int solution(int[][] board) {
        n = board.length;
        this.board = board;
        this.dist = new int[n][n][2];
        /*
            이동에 따른 제약이 특이한 문제
            기존 bfs는 해당 칸이 1인지 아닌지 정도의 체크
            이 문제는 이동하는 사이즈가 애초에 2.
            그래서 오른쪽, 아래, 회전에 따른 제약이 다름
            그래서 노드에 담기는건 2개의 좌표로 총 4개?
            그리고 방문체크는 어떻게하지? 1칸짜리면 간선 비용이 다 1이라서 한 번 방문하면 끝
            여기선 2칸짜리가 동시에 같은 모양으로 있을때만 겹치는 방문으로 체크해야하나?
            왼쪽또는 위좌표를 r,c로하고 방향이 오른쪽으면 0, 아래면 1로해서 3차원 방문배열
            
        */
        visited = new boolean[n][n][2];
        dist[0][0][0] = 0;
        return bfs(0, 0);

    }
    
    /*
        가로냐 세로냐에 따라 오른,아래,회전이 각각 다 다른가?
        가로
         -오른쪽 : r,c+1,0 방문체크. r,c+2가 1이 아님
         -왼쪽 : r,c-1,0 방문체크. r,c-1가 1이 아님
         -위 : r-1,c,0 방문체크, r-1,c r-1,c+1이 1이 아님
         -아래 : r+1,c,0 방문 체크. r+1,c r+1,c+1이 1이 아님
         -회전 : 
            축의 2좌표에서 회전가능. 위아래. 총 4가지. 그래도 위,아래 각각 필요칸이 같음
            위: r-1,c r-1,c+1  / 1이 아님
            아래: r+1,c r+1,c+1 / 1이 아님
        세로
         -오른쪽 : r,c+1,1 방문체크. r,c+1, r+1,c+1가 1이 아님
         -왼쪽 : r, c-1,1 방문체크. r,c-1, r+1,c-1가 1이 아님
         -위 : r-1,c,1 방문체크. r-1,c가 1이 아님
         -아래 : r+1,c,1 방문체크. r+2,c가 1이 아님
         -회전
            오른: r,c+1 r+1,c+1 / 1이 아님
            왼 : r,c-1 r+1,c-1 / 1이 아님
    */
    public int bfs(int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c,0});
        visited[r][c][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curDir = cur[2];
            int curDist = dist[curR][curC][curDir];
            if (curDir == 0) {
                if (curR == n - 1 && curC == n - 2) {
                    return dist[n-1][n-2][0];    
                }
            } else {
                if (curR == n - 2 && curC == n - 1) {
                    return dist[n-2][n-1][1];
                }
            }
            for (int[] next :getNextStates(cur)) {
                int nextR = next[0];
                int nextC = next[1];
                int nextDir = next[2];
                if (!visited[nextR][nextC][nextDir]) {
                    visited[nextR][nextC][nextDir] = true;
                    queue.offer(new int[]{nextR, nextC, nextDir});
                    dist[nextR][nextC][nextDir] = curDist + 1;
                }    
            }
            
        }
        return -1;
    }
        
    public List<int[]> getNextStates(int[] cur) {
        int r = cur[0];
        int c = cur[1];
        int dir = cur[2];
        List<int[]> result = new ArrayList<>();
        if (dir == 0) { // 가로
            if (c + 2 < n && board[r][c+2] != 1) { // 오른쪽
                result.add(new int[]{r, c+1, 0});        
            }
            if (c - 1 >= 0 && board[r][c-1] != 1) { // 왼쪽
                result.add(new int[]{r, c-1, 0});
            }
            if (r - 1 >= 0 && board[r-1][c] != 1 && board[r-1][c+1] != 1) { // 위, 회전2개
                result.add(new int[]{r-1, c, 0}); // 위
                result.add(new int[]{r-1, c, 1}); // r,c에서 위
                result.add(new int[]{r-1, c + 1, 1}); // r, c+1에서 위
            }
            if (r + 1 < n && board[r+1][c] != 1 && board[r+1][c+1] != 1) { // 아래, 회전2개
                result.add(new int[]{r+1, c, 0});
                result.add(new int[]{r, c, 1});
                result.add(new int[]{r, c+1, 1});
            } 
          
        } else { // 세로
            if (c + 1 < n && board[r][c+1] != 1 && board[r+1][c+1] != 1) { //오른, 회전
                result.add(new int[]{r, c+1, 1}); // 오른    
                result.add(new int[]{r, c, 0}); // 위에서 오른회전
                result.add(new int[]{r+1, c, 0}); // 아래에서 오른회전
            }  
            if (c - 1 >= 0 && board[r][c-1] != 1 && board[r+1][c-1] != 1) {//왼, 회전
                result.add(new int[]{r, c-1, 1}); // 왼
                result.add(new int[]{r, c-1, 0}); // 위에서 왼회전
                result.add(new int[]{r+1, c-1, 0}); // 아래에서 왼회전
            }
            if (r - 1 >= 0 && board[r-1][c] != 1) { // 위
                result.add(new int[]{r-1, c, 1}); // 위
            }
            if (r + 2 < n && board[r+2][c] != 1) { // 아래
                result.add(new int[]{r+1, c, 1}); // 아래
            }
        }
        return result;
            
    }
}