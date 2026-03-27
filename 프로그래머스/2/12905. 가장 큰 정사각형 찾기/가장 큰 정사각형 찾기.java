class Solution{
    public int solution(int[][] boardOld) {
        
        /*
            dp로 오른쪽 아래 지점을 기준으로 풀기
            왼쪽 위쪽 0-패딩둬서 굳이 dp식 분기안하고 하나로 통일
        */
        int m = boardOld.length + 1;
        int n = boardOld[0].length + 1;
        int[][] board = new int[m][n];
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                board[i][j] = boardOld[i - 1][j - 1];        
            }
        }
        /*
            board[i][j]가 1일 때 왼 위 왼위까지의 정사각형넓이 정보를 어떻게 활용?
            dp는 해당 좌표를 오른쪽아래 좌표로하는 정사각형의 최대 변의길이
        */
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 
                    Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}