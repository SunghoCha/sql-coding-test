import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;
        /*
            +n, *2, *3 을 제한없이 해서 x를 y로 만들떄 최소 횟수구하기.
            근데 불가능한지는 어떻게 체크하는거지? 횟수제한도 없는데?
            함수돌리면서 모든 경우에 n보다 커지면 return하게 하면?
            처음 ans를 -1로해놓으면?
            그래서 이건 백트래킹인가? 방문배열도없고...
            중복가능에...
            depth 필요없음 n과의 대소비교가 베이스조건
        */
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1); 
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        return (dp[y] == Integer.MAX_VALUE) ? -1 : dp[y];
        
        
    }
    
  
}