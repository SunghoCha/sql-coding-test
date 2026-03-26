import java.util.*;
class Solution {
    public int solution(String[] boardStr) {
        
        /*
            상하좌우 탐색하는 bfs인데 이동의 개념이 좀 다름
            한 칸 이동이 아니라 특정조건 만족할떄까지 이동
            방향바꾸는 횟수정보를 노드가 가져야함
            큐가 다 돌고 없으면 -1
            방문배열은? 이동방식이 특이해서 교차나오는듯?
            없이하면 무한루프나오나? 있으면 제대로 이동이 안될거같은데?
            방문배열에 노드와 방향을 담아서 2차원으로?
        */
        int ans = 0;
        int m = boardStr.length;
        int n = boardStr[0].length();
        char[][] board = new char[m][n];
        boolean[][] visited = new boolean[m][n];
        int x = 0;
        int y = 0;
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < m; i++) {
            char[] chars = boardStr[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char ch = chars[j];
                if (ch == 'R') { // 시작점 찾기
                    x = i;
                    y = j;
                }
                if (ch == 'G') {
                    targetX = i;
                    targetY = j;
                }
                board[i][j] = chars[j]; // 2차원 배열채우기
            }
        }
        Deque<Node> queue = new ArrayDeque<>();
        // 방향은 처음에 0으로? 1로? 방향전환할때 카운팅?
        // 이러면 해당 방향에서 도착하면 카운팅이 안됨
        // 그렇다고 해당방향처음이동하는 순간 특정하기도 애매함 그냥 방향전환, 찾으면 카운팅
        int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
        int[] dy = {0, 0, -1, 1};
        queue.offer(new Node(x, y, 0)); 
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                // 새 포인트가 유효한동안 갱신
                int newX = curNode.x;
                int newY = curNode.y;
                while (newX >= 0 && newX < m && newY >= 0 && newY < n
                      && board[newX][newY] != 'D') {
                    newX += dx[i];
                    newY += dy[i];
                }
                //여기로 왔다는건 유효하지않은 위치 or D에 막힘. D에 막힌 G인지도 체크
                //우선 한포인트 뒤로 후진
                newX -= dx[i];
                newY -= dy[i];
                if (visited[newX][newY]) {
                    continue;
                }
                // G인가?
                if (newX == targetX && newY == targetY) {
                    return curNode.count + 1; // g만나면 +1해야 맞음    
                }
                // G가 아니라면 방향전환해야함
                queue.offer(new Node(newX, newY, curNode.count + 1));
                visited[newX][newY] = true;
            }
        }
        
        return -1;
    }
    
    public static class Node {
        int x;
        int y;
        int count;
        
        Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.count = c;
        }
    }
}