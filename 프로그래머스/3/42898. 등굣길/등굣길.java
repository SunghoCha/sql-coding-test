class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        /*
            m -> 가로 y, n -> 세로 x    -> n * m
            좌표 시작점은 (1,1) -> 1-base이므로 인덱스 주의
            가로세로를 그냥 수학좌표계처럼 했는데 무시하고 전체를 일관되게 반대로 사용해도 답 나옴
            m을 세로로 받아들이고 n을 가로로받아들임. 인덱스만 주의
            
            오른쪽과 아래로만 움직임. 최단경로 개수 구하기
            1000000007로 나눈 나머지 리턴. dp로 한다면 매번 이걸 적용해야할듯
            물에 잠긴 지역은 0 ~ 10개
            근데 못움직이는 지역보면 마치 bfs같은데 ? 격자크기도 100 * 100정도임
            오른쪽으로 99번 아래로 99번가능해서 최대 2^198이라서 bfs 불가능
            dp로 접근해야할듯. 근데 물웅덩이가 있는 지점 먼저 체크하고?
            경계는? 0으로패딩을 둘러야하나?
        */
        int[][] dp = new int[n + 1][m + 1]; // 왼쪽 위쪽. 이러면 알아서 0-base로 해도 될 듯?
        boolean[][] blocked = new boolean[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            int[] cur = puddles[i];
            blocked[cur[1]][cur[0]] = true;    
        }
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (blocked[i][j] || (i == 1 && j == 1)) {
                    continue;    
                }               
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        int answer = dp[n][m];
        return answer;
    }
}