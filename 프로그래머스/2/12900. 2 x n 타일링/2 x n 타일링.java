class Solution {
    public int solution(int n) {
        int answer = 0;
        /*
            왠지 dp로 푸는 문제같음? 그냥 누적합인가?
            n = 4 
            dp[4] = dp[1] + 2 * dp[2]
            이걸로 바로 일반화 가능한가? 아니면 홀짝을 좀 생각해봐야하나?
            일단 바로 일반화해보자
            dp[3] = dp[2] + 2 * dp[1] = 4
            dp[2] = dp[1] + 2 * dp[0] // dp[2]는 식 예외로 그냥 계산하는듯
            
            
            dp[1] = 1
            dp[2] = 2            
            dp[3] = 4
            
            dp[4] = 5 -> 틀렸음 짝수,홀수 식이 다른듯
            dp[5] = ..
            홀수일때 -> 짝수 * 2?
            짝수일떄 -> 
        */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
    
    
}