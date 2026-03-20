import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

       /*
            완전탐색은 4의 100000 제곱이라 불가능
            한 행에서 하나 선택. 같은 열 연속 선택 불가
            dp로 푸나?
            경계조건 고려해서?
            
            경계아닐때 (가운데 두 열) 
            총 4가지 열에서 하나를 제외한 3열이 모두 가능
            dp[i][j] = dp
            
            경계일 때 (양끝 두 열)..
            
            이건 이어진부분만이 아니라 그냥 같은 열만 아니면 되니까
            무조건 3개가 가능한데? 경계조건 고려가 아닌듯?
            애초에 dp도 아닐수 있나?
            그냥 바로 이전의 열 정보만 있으면 10만개에 대해서 체크하면서
            내려오나? 그리디가능? 근데 그리디는 아닐듯?
            예를 들어 현재 5가 최대라 선택했더니 바로 다음 100000을 선택못할수있음
            그리디가 아니고 완탐도 안됨...
            결국 dp?
            
            dp[i][j] = dp[i - 1][해당 j 제외...]
            j를 식으로 표현하기가 애매하네.. 단순히 j -1이런식으로 불가능
            j에 대한 루프 돌면서 현재 j와 같은거 제외하고 최대값갱신? 이 변수는 루프밖에 두고?
            
       */
        int n = land.length;
        int[][] dp = new int[n][4];
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < 4; j++) { // 첫행인지 아닌지
                if (i == 0) {
                    dp[i][j] = land[i][j];
                    continue;
                }
                int pre = getMax(dp, i, j);
                dp[i][j] = land[i][j] + pre;
                
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = Math.max(ans, dp[n - 1][i]);
        }
        return ans;
    }
    
    public int getMax(int[][] dp, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = 0; k < 4; k++) {
            if (k == j) { // 같은 열 스킵
                continue;
            }
            max = Math.max(max, dp[i - 1][k]); // 이전 행들 중 max 값    
        }
        return max;
    }
}