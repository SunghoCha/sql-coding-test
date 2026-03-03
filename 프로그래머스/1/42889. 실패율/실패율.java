import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] stageCount = new int[N + 2]; // 0, 1, ~ N + 1. 스테이지별 대기 인원
        int totalNum = stages.length;
        for (int i = 0; i < totalNum; i++) {
            int num = stages[i]; // 스테이지 넘버 반환
            stageCount[num]++; // 해당 스테이지에 사람수 추가
        }
        int stay = 0; // 이전 스테이지까지의 대기인원 누적합
        // 실패율 : 스테이지별 대기인원 / totalNum - stay
        double[][] fail = new double[N][2]; // 스테이지별 실패율. (스테이지번호, 실패율)
        for (int i = 0; i < N; i++) { // 스테이지 1 ~ N번만 필요 0-base
            int num = totalNum - stay;
            fail[i][0] = i;
            if (num == 0) {
                fail[i][1] = 0;
            } else {
                fail[i][1] = (double) stageCount[i + 1] / num;
            }
            stay += stageCount[i + 1];
        }
        Arrays.sort(fail, (a, b) -> {            
            if (a[1] == b[1]) {
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]);
        });
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) fail[i][0] + 1;
        }
        return answer;    
        
    }
}