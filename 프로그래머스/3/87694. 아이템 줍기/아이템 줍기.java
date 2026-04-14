import java.util.*;
class Solution {
    int m = 0;
    int n = 0;
    int cX = 0;
    int cY = 0;
    int iX = 0;
    int iY = 0;
    int size = 0;
    boolean[][] isEdge;
    boolean[][] isInside;
    boolean[][] isBound;
    public int solution(int[][] rectangle, int cX, int cY, int iX, int iY) {
        this.cX = 2 * cX;
        this.cY = 2 * cY;
        this.iX = 2 * iX;
        this.iY = 2 * iY;
        
        m = rectangle.length; // 직사각형 개수
        n = rectangle[0].length; // 
        size = 101;
        isEdge = new boolean[size][size];
        isInside = new boolean[size][size];
        isBound = new boolean[size][size];
        for (int i = 0; i < m; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            markEdge(x1, y1, x2, y2);
            markInside(x1, y1, x2, y2);   
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isEdge[i][j] && !isInside[i][j]) {
                    isBound[i][j] = true;    
                }
            }
        }
        int[][] dist = new int[size][size];
        for (int[] arr: dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }    
        return bfs(dist);
        
    }
    
    public int bfs (int[][] dist) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{cX, cY});
        dist[cX][cY] = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            if (curX == iX && curY == iY) {
                return dist[curX][curY] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                    if (isBound[nx][ny] && dist[nx][ny] == Integer.MAX_VALUE) {
                        queue.offer(new int[]{nx, ny});
                        dist[nx][ny] = dist[curX][curY] + 1;
                    }
                }
            }
        }
        return -1;
    }
    /*
        세로
        x1,y1 ~ x1,y2
        x2,y1 ~ x2,y2
        가로
        x1,y1 ~ x2,y1
        x1,y2 ~ x2,y2
    */
    public void markEdge(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            isEdge[x1][i] = true;
            isEdge[x2][i] = true;
        }
        for (int i = x1; i <= x2; i++) {
            isEdge[i][y1] = true;
            isEdge[i][y2] = true;
        }
    }
    
    public void markInside(int x1, int y1, int x2, int y2) {
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++) {
                isInside[i][j] = true;
            }
        }
    }
}