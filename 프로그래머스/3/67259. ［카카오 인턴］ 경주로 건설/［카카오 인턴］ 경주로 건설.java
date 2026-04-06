import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n = 0;
    List<Integer> list = new ArrayList<>();
    public int solution(int[][] board) {
        this.n = board.length;
        
        /*
            인접한 두 빈칸을 상하 or 좌우로 연결하면 직선도로
            직선도로가 서로 직각으로 만나는 지점을 코너
            직선도로 하나당 100원, 코너 하나당 500원
            최소비용 계산.
            방향이 꺾일때 비용 계산해야함
            근데 이 문제는 bfs같은데...
            단순히 상하좌우로 움직이는것뿐만 아니라 방향에 대한 정보가 있어야함
            node를 x,y,dir 로해서 int[]로 묶어서 관리?
            거리개념은? x,y,dir,dist 로해서 int[]?
            dir : 상하좌우 0,1,2,3 인덱스로 하고 dx, dy로 정의
        */
        
        int[][][] costs = new int[n][n][4];
        for (int[][] plane : costs) {
            for (int[] row : plane) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        bfs(board, costs);
        list.sort((a, b) -> a - b);
        return list.get(0);

    }
    
    public void bfs(int[][] board, int[][][] costs) {

        Deque<int[]> queue = new ArrayDeque<>();
        // x, y, cost, dir
        queue.offer(new int[]{0,0,0,1}); // 하
        queue.offer(new int[]{0,0,0,3}); // 우

        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int cost = 100;
                if (cur[3] != i) {
                    cost += 500;
                }
                int nextCost = cur[2] + cost;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (nextCost < costs[nx][ny][i] && board[nx][ny] != 1) {

                        costs[nx][ny][i] = nextCost;
                        queue.offer(new int[]{nx, ny, nextCost, i});
                        if (nx == n - 1 && ny == n - 1) {
                            list.add(nextCost);
                        }
                    }
                }
            }
        }
        
            
    }
}