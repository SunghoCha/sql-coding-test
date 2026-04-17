import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        /*
            1시간당 능력치 하나 1증가 가능
            문제를 풀어서 능력치얻음. 시간소요. 반복풀이 가능
            모든 문제들을 풀 수 있는 알고력과 코딩력을 얻는 최단시간
            모든 문제들을 풀 수 있는지 알려면 모든 문제들을 탐색하긴해야함
            이 문제는 그라디인걸까?
            애초에 감으로 그라디를 떠올리는것부터 잘못된거아닌가?
            문제특성에 대한 분석도 아니고 말이야.
            
            1시간 or 문제풀이로 능력 올려야함.
            결국 목표는 모든 문제를 푸는것이 아니고 가장 높은 문제의 알고력과 코딩력 이상의 능력치 달성
            일단 문제사이즈는 작아서 완탐도 상관없어보이는데?
            그리고 같은 문제 여러번푸는것도 가능..
            여기까지보면 마치 동전문제처럼 보임.
            그라디나 dp처럼 보임..
            그라디인 경우는 사용가능한 것들이 약수관계일때만 가능했는데
            그렇다고 이게 dp인걸까? 최적부분해와 중복의 특징을 가지는건가?
            최적부분해
                어떤 특정한 알고력과코딩력을 달성했을때 그 경로가 미래에 영향을 안 주면 최적부분해인가?
                근데 미래에 영향주는것들은 dp상태로 흡수하던데..
            중복
                그 최적부분해를 여기저기서 사용? 뭔가 논리가 빈약함..
                
            어쨌든 dp라고 하고나서 정의해보자
            dp 몇차원인지도 아직 모름. 일단 정의부터
            dp : 특정한 알고력과 코딩력을 만족시키기 위한 최소시간
            여기서 상태정의가 중요함. 대충 직관에 의해서 하면 안됨
            상태는 미래 선택에 영향을 주는것? 뭐라고 정의하지?
            막연하게는 그냥 dp[알고력][코딩력] ? 
            
            초기값 정의는  dp식 완성하고나서 뭐가필요한지 파악해보자
            여러 경로를 통해서 올 수 있고 이 중에서 최소값이니 Math.min 사용할듯?
            그리고 여기서 1시간 공부해서 a+1 or c+1 or 특정문체풀이로 a,c에 각각 플러스
            3가지 방식인듯?
            
            int[] problem = problems[i];
            int aP = problem[0];
            int cP = problem[1];
            int aGet = problem[2];
            int cGet = problem[3];
            int cost = problem[4];
            // 내가 이 dp를 풀 수 있는 상태임을 먼저 체크
            
            dp[a][c] = Math.min(dp[a][c] , dp[a - 1][c] + 1, 
            dp[a][c - 1] + 1);
            if (내가 이 dp를 풀 수 있는 상태라면) {
                dp[a][c] = Math.min(dp[a][c], dp[a - aGet][c - cGet] + cost);
            }
            -----------------------------------------------------
            리뷰받은부분
            a-aGet, c-cGet에서 이 문제를 풀 수 있는 상태였다는것
            a-aGet > aP && c-cGet > cP
            -----------------------------------------------------
            
            
        */
        int maxA = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        for (int[] problem : problems) {
            int needA = problem[0];
            int needC = problem[1];
            maxA = Math.max(maxA, needA);
            maxC = Math.max(maxC, needC);
        }
        maxA = Math.max(maxA, alp);
        maxC = Math.max(maxC, cop);
        int[][] dp = new int[maxA + 1][maxC + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);    
        }
        // dp[][] 초기화
        dp[alp][cop] = 0; 
        for (int a = alp; a <= maxA; a++) {
            for (int c = cop; c <= maxC; c++) {
                // if (a > 0 && dp[a-1][c] != Integer.MAX_VALUE) {
                //     dp[a][c] = Math.min(dp[a][c], dp[a - 1][c] + 1);
                // }
                if (a + 1 <= maxA) {
                    dp[a+1][c] = Math.min(dp[a+1][c], dp[a][c] + 1);
                }
                // if (c > 0 && dp[a][c - 1] != Integer.MAX_VALUE) {
                //     dp[a][c] = Math.min(dp[a][c], dp[a][c - 1] + 1);
                // }
                if (c + 1 <= maxC) {
                    dp[a][c+1] = Math.min(dp[a][c+1], dp[a][c] + 1);
                }
                for (int[] pro : problems) {
                    int needA = pro[0];
                    int needC = pro[1];
                    int getA = pro[2];
                    int getC = pro[3];
                    int cost = pro[4];

                    // if (a-getA >= needA && c-getC >= needC) {
                    //     dp[a][c] = Math.min(dp[a][c], dp[a-getA][c-getC] + cost);
                    // }
                    if (a >= needA && c >= needC) {
                        int nextA = Math.min(maxA, a+getA);
                        int nextC = Math.min(maxC, c+getC);
                        dp[nextA][nextC] = Math.min(dp[nextA][nextC], dp[a][c] + cost);    
                    }
                }
            }
        }
        
        
        return dp[maxA][maxC];
    }
}