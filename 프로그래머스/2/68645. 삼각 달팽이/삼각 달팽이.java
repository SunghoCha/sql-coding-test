class Solution {
    public static int[][] board;
    public int[] solution(int n) {
        int[] answer = {};
        /*
            2차원배열에서 왼직각삼각형 형태로 채워넣기
            아래, 오른, 왼위대각 반복
            n, n - 3 .. n - 3 > 0이어야함 
            개수를 n개씩 채운다로 가면 처음만 n개고 겹쳐서 n-1, n-2개 채우는데..
            인덱스위치로 지정하면 2번째 삼각형부터 애매하지나?
            근데 결국 배열을 채우려면 배열의 인덱스를 지정해야만하는데..
            이걸 메서드분리하고 인자로 시작인덱스와 시작값, 전진범위를 전달받도록?
            n - 3> 0인 조건으로해야하니까 n을 while 밖인자로 주고 갱신?
            한바퀴 도는 메서드가 돌고나서 다음 n값을 반환하도록하고 이걸로 while 조건문 체크
        
                
        */
        board = new int[n][n];
        int len = n;
        int[] dx = {1, 0, -1}; // 하, 우, 좌상
        int[] dy = {0, 1, -1};
        int dir = 0;
        int num = 1;
        int x = -1;
        int y = 0;
        while (len > 0) {
            
            for (int i = 0; i < len; i++) {
                x += dx[dir];
                y += dy[dir];
                board[x][y] = num++;
            }
            dir = (dir + 1) % 3;
            len--;
        }
        int idx = 0;
        int[] ans = new int[(n * (n + 1)) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    ans[idx] = board[i][j];
                    idx++;
                }
            }
        }
        
        
        return ans;
    }
    

}