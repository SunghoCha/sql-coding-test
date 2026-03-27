import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        /*
            맨해튼 거리 2이하 금지면 다이아몬드모양
            파티션으로 막혀있으면 허용
            2번 이내에 도달가능한지를 보면됨
            응시자 P, 빈 테이블 O, 파티션 X
            
            대기실크기 5 * 5, 대기실 총 5개
            그냥 5번 반복이지 대기실개수는 의미없음
            
            그냥 각 대기실에서 p를 찾고 bfs해서 다른 p에 도달되는순간 return 0
            다른 p도달할떄 거리계산해서 2이하인지 체크해야함
            이러면 노드객체?
            근데 이 거리계산이 쉽지않음
            근데 크기 5*5면 굳이 bfs로 해야하나?
            그냥 보드에서 p찾으면 거리2 이내에 있는지 체크하면 되는거아닌가?
            
        */
        int[] ans = new int[5];
        for (int k = 0; k < places.length; k++) {
            String[] arr = places[k];
            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                char[] chars = arr[i].toCharArray();
                for (int j = 0; j < 5; j++) {
                    board[i][j] = chars[j]; 
                }
            } // 보드완성
            
            ans[k] = find(board); 
                      
        }
               
        return ans;
    }
    
    public int find(char[][] board) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 'P') {
                    int result = bfs(board, i, j);
                    if (result == 0) {
                        return 0;   
                    }
                }
            }
        }
        return 1;
    }
    
    public int bfs(char[][] board, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dis = cur[2];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                int nDist = dis + 1;
                /*
                    X면 그냥 스킵
                    방문안한 O면 방문체크후 큐 추가
                    P일 경우 거리가 2이상?
                    P일 경우 거리 2초과?
                    그리고 주의할게 P는 방문체크없이 동작해야하는데..
                    P가 다른 P에서 방문되었다고해서 탐색못하면 안되지않나?
                    P마다 방문배열 둬야할듯? 지금 그러고 있는듯함. 이건 OK.
                    
                    
            
                */
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (board[nx][ny] == 'X') {
                        continue;
                    }
                     // p에선 방문체크 필요없나?
                    if (!visited[nx][ny] && board[nx][ny] == 'P' && nDist <= 2) {
                        return 0;
                    }
                    if (!visited[nx][ny] && board[nx][ny] == 'O') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, nDist});
                    }
                    if (!visited[nx][ny] && board[nx][ny] == 'P' && nDist > 2) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, nDist});    
                    }
                    
                }
            }
            
        }
        return 1;
    }
}