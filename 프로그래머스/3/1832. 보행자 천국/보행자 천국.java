class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] city) {
        
        /*
            bfs인가? dp인가?
            근데 방향이 정해져있으니 dp?
            도착만 하면 됨
            1이면 불가 2면 왼쪽은 오른쪽, 위에서오는건 아래쪽
            아래 오른쪽으로만 이동가능. 
            현재 나의 좌표가 0,1,2인지에 따라서만 갈리는?
            경계는? 패딩으로 처리가능한지 체크
            dp[i][j] ~ dp[i-1][j], dp[i][j-1]
        */
       
        
        int[][][] dp = new int[m][n][2]; 
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        // 0 왼쪽, 1 위
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int num = city[i][j];
                if (num == 1) {
                    dp[i][j][0] = 0;                    
                    dp[i][j][1] = 0;
                } else if (num == 0) {
                    long arriving = 0;
                    if (i > 0) {
                        arriving += dp[i-1][j][1];    
                    }
                    if (j > 0) {
                        arriving += dp[i][j - 1][0];
                    }
                    dp[i][j][0] = (int) (arriving % MOD);
                    dp[i][j][1] = (int) (arriving % MOD);
                    
                } else { // num == 2
                    if (j > 0) {
                        dp[i][j][0] = dp[i][j - 1][0];
                    }
                    if (i > 0) {
                        dp[i][j][1] = dp[i - 1][j][1];
                    }
                        
                }
            }      
        }
        return dp[m - 1][n - 1][0];
    }
}