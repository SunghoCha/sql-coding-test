import java.util.*;
class Solution {
    int n = 0;
    int min = Integer.MAX_VALUE;
    public int solution(int[][] matrixs) {
        n = matrixs.length;
        
        /*
            dp[i][j] : [i,j] i ~ j번째 행렬구간. 
            dp초기화
            일단 dp식부터하고 필요한 초기화 생각
            dp[i][j] = for k = i ~ j. dp[i][k] + dp[k + 1][j]
            일단 dp[i][i] = 0 (대각)
            i > j 인영역은 사용안함. 대각선0으로 하고 그 윗 삼각형부분만 사용
            그리고 matrixs 이용해서 계산한 비용 처음에 저장해야하는데
            크기 2짜리 구간은 다 저장해놔야하지않나?
            그러면 2초과하는 구간은 알아서 계산되는?
            
        */
        int[][] dp = new int[n][n]; //0 번째에서 n-1번째. 0-based
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    int mergeCost = matrixs[i][0] * matrixs[k][1] * matrixs[j][1];
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + mergeCost + dp[k + 1][j]);
                }
            }    
        }       
        
        return dp[0][n - 1];
    }
}