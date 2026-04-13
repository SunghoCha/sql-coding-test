import java.util.*;
class Solution {
    int[] dartCounts;
    int[] singBullCounts;
    public int[] solution(int target) {
        
        /*
            부분최적해, 중복구조 ->  dp
            최적의 정의 : 최소다트수, 싱글/불 최대
            최적의 조건을 압축해가면서 dp[target]의 값 얻기
            
            상태 ~ 현재점수, 최소다트수, 싱글/불 최대
            dp는 몇차원? 최소다트수와 싱글/불최대수는 최적의조건이라서 매번 압축해서 가져가도됨
            그러므로 현재점수만 가지고 1차원 dp를 하면서 최소다트수, 싱글/불최대수를 압축하면서 가져간다
        */
        dartCounts = new int[target + 1];
        singBullCounts = new int[target + 1];
        
        Arrays.fill(dartCounts, Integer.MAX_VALUE);
        dartCounts[0] = 0;
        for (int i = 0; i <= target; i++) {
            
            for (int j = 1; j <= 20; j++) {
                tryUpdate(i, j, 1); // i, j, 싱글/불카운트
                tryUpdate(i, j * 2, 0);
                tryUpdate(i, j * 3, 0);
            }
            tryUpdate(i, 50, 1);
        }
        
        
        return new int[]{dartCounts[target], singBullCounts[target]};
    }
    
    /*
        score - dart의 다트카운트 + 1이 score의 다트카운트보다 작은지 비교
        작으면 적용가능
        같으면
        score - dart에서의 sinbull카운트 + singbull이 score에서의 sinbull카운트보다 작으면 적용가능
    */
    public void tryUpdate(int score, int dart, int singBull) {
        if (score < dart) return; 
        if (dartCounts[score - dart] + 1 < dartCounts[score]) {
            dartCounts[score] = dartCounts[score - dart] + 1;
            singBullCounts[score] = singBullCounts[score - dart] + singBull;
            return;
        }
        if (dartCounts[score - dart] + 1 == dartCounts[score]) {
            if (singBullCounts[score - dart] + singBull > singBullCounts[score]) {
                dartCounts[score] = dartCounts[score - dart] + 1;
                singBullCounts[score] = singBullCounts[score - dart] + singBull;
                return;
            }    
        }
        return;
    }
}