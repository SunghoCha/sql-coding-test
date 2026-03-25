import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        /*
            무조건 레버를 거친후에 탈출해야함
            그러면 출발 - 레버 / 레버 - 도착
            이렇게 분리한 2개에 대한 최단경로 구한다음에 합치면?
            두 개의 bfs?
            모든 통로 출구 레버 시작점은 여러번 지나갈수있다?
            그럼 방문배열없이 그냥 최초 도착시에 카운팅?
            근데 최초도착하는데 중복이 나올리가 없는데?
            이건 출구 ~ 레버까지 이어서볼떄만 나오는 케이스일듯.
            근데 대각이동은 안된다고 보면되나?
        */
        //String[] 그대로전달? 아니면 char[][]로할까?
        // S, E, L ,O, X.  -> 최소한 S, E or L는 알아야함. 
        char[][] boards = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) { // boards 초기화
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                boards[i][j] = chars[j];    
                
            }
        }
        
        int x = 0;
        int y = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                if (boards[i][j] == 'S') {
                    x = i;
                    y = j;
                } else if (boards[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
                
            }
        }
        int start = bfs(boards, x, y);
        int end = bfs(boards, endX, endY);    
        if (start == -1 || end == -1) {
            return -1;
        }
        return start + end;
    }
    
    public int bfs (char[][] board, int a, int b) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(a, b, 0));
        visited[a][b] = true;
        
        int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Node cur = queue.poll(); 
            
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // 유효한 범위인지 체크
                if (newX >= 0 && newX < m && newY >= 0 
                    && newY < n && !visited[newX][newY]) {
                    
                    char target = board[newX][newY];
                    if (target == 'X') {
                        continue;
                    } else if (target == 'L') {
                        return count + 1; // 현재 위치에서 1칸 이동했으므로.
                    } else {
                        queue.offer(new Node(newX, newY, count + 1));
                        visited[newX][newY] = true;
                    }
                    
                }
                
            }
            
        }
        return -1; // L도달 못하면 여기서 리턴
    }
    
    public class Node {
        int x;
        int y;
        int count;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}