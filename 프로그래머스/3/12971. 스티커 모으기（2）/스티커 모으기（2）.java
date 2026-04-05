class Solution {
    public int solution(int sticker[]) {
        
        /*
            스티커 한장 선택하면 양옆은 사용불가
            선택은 결국 홀수번째 아니면 짝수번째 같은데?
            주의할건 원형이라서 총 개수가 홀수개일떄 양끝 선택 불가인 케이스가 존재.
            
            리뷰받음
            잘못생각했음 적혀있는 숫자크기에 따라 달라짐.
            최대개수를 뽑는다고 그게 최대값을 보장하지않기때문..
            
            dp이고 가장 앞을 포함하는지 안하는지여부로 원형배열 문제 해결?
            i번째 입장에서 신경쓸건 i -2번째가 뽑힌 케이스, 안 뽑힌 케이스?
            dp[i] = dp[i - 2] + sticker[i] ?
            dp[i] = dp[i - 1] + sicker[i]?
            이게 말이안됨 이러면 i는 항상 뽑힌다는건데 이렇게하면 점화식 자체가불가능
            항상 i번쨰 기준?
            i가 뽑히는 경우 
            dp[i] = dp[i - 2] + sticker[i];
            i가 안 뽑히는 경우
            dp[i] = dp[i - 1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
            
            여기서 첫번째를 포함한 케이스와 포함하지않은 케이스를 따로 해서 2가지중 큰걸로?
            표현은 어떻게?
            그냥 i를 0부터해서 구한것과 1부터해서 구한것 2개를 각각 구해서 비교?
            
        */
        /*
            근데 dp0 ,1을 미리 정의가능? 사이즈가 1짜리도 있는데..
            i = 2부터 정의해야하는데
        */
        int n = sticker.length;
        if (n == 1) {
            return sticker[0];
        }
        
        // 첫번째 요소선택 케이스
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for (int i = 2; i < n - 1; i++) { //n == 2일떄 어떻게 되는지 체크. i == n - 1은 아예 무시?
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);        
        }
        
        // 첫번쨰 선택안한 케이스
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        int ans = Math.max(dp1[n - 2], dp2[n - 1]);
        return ans;
    }
}