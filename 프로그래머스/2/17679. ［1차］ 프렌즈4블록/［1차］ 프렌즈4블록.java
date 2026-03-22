class Solution {
    // 상 우 우상
    static int[] dx = {-1, 0, -1};
    static int[] dy = {0, 1, 1};
    public int solution(int m, int n, String[] boardStr) {
        int answer = 0;
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = boardStr[i].toCharArray();
        }

        /*
            marked에 삭제할 대상 마크는 했는데..
            바로 윗줄하고 스왑하는 식으로하면 안됨. 
            스왑을 해당 열의 맨 위까지 하는 버블형?
            해당 열의 값들을 뽑아서 아래부터 다시 채우기? 매번?
            이건 그냥 한 번만해도 될 듯? 열의 개수만큼만 하면 알아서 정렬될듯?
            그리고 이 전체과정을 언제까지해야하지? 지워질게없을떄까지해야하는데?
            지워진건 카운팅해서 while로 0개 체크?
        */
        // 모든 열을 루프돌면서 해당 열에서 mark 안된것들만 아래행부터 채워야함
        // 이건 포인터써서해야하나? 아니면 while? for? 다 되는건가?
        // board에 포인터를 두고 marked에서 false인것들을 옮긴다?
        // 포인터는 marked를 스캔하는 인덱스값 이하이므로 값을 옮겨담는
        // 별도의 배열 없이 board에서 바로 수행가능?
        
        while (true) {
             boolean[][] marked = new boolean[m][n];
            // 보드에서 4개 붙어 있는 경우 찾아서 마킹
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isMarkable(i, j, board)) {
                        mark(i, j, marked);        
                    }
                }
            }
            int count = play(m, n, board, marked);
            if (count == 0) {
                break;
            }
            answer += count;    
        }
        
        
        return answer;
    }
    
    public int play(int m, int n, char[][] board, boolean[][] marked) {
        
        int count = 0;
        for (int j = 0; j < n; j++) {
            int pointer = m - 1;
            for (int i = m - 1; i >= 0; i--) { // 
                if (marked[i][j] == true) {
                    count++;
                    continue;
                }   
                board[pointer][j] = board[i][j];
                pointer--;
            }// marked에선 m -1 ~ 0 다 스캔 했지만 board에서는 m - 1 ~ pointer이전까지만 완성됨 
            for (int i = pointer; i >= 0; i--) {
                board[i][j] = '0';
            }
        }
        return count;
    }
    
    public boolean isMarkable(int x, int y, char[][] board) {
        char target = board[x][y]; // 주어진 x,y 지점에 대한 3가지 포인트에 대해서 체크
        if (target == '0') {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (board[newX][newY] != target) {
                return false;
            }
        }
        return true;
        
    }
    public void mark(int x, int y, boolean[][] marked) {
        marked[x][y] = true;
        for (int i = 0; i < 3; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            marked[newX][newY] = true;
        }
    }
}