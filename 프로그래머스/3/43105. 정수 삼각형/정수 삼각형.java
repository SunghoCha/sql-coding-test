class Solution {
    public int solution(int[][] triangle) {
        
        /*
            왼쪽에 붙어있는 삼각형으로 처리
            바로아래 또는 우하향대각선
            거쳐간 숫자의 최대값
            어떤 경로가 최선인지 매순간 알 수 없음    
            dp로 풀 떄 새로운 배열없이 기존 triangle 이용 가능?
            0,0
            1,0 1,1
            2,0 2,1 2,2
            근데 양 끝의 dp는 좀 다른듯?
            나머지는 두 군데에서 내려오는데 양끝은 한군데서만 내려옴
            i = 0 : 
        */
        int[][] dp = triangle;
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) { // 첫행 제외
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                    
                } else if (j == i) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                    
                } else {
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1] , dp[i - 1 ][j]);
                   
                } 
            }    
        }
        int m = dp.length;
        int n = dp[m - 1].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[m - 1][i]);
        }
       
        return max;
    }
}