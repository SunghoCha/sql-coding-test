class Solution {
    public int solution(String s) {
        int answer = 0;
        /*
            첫문자열 선택 target
            탐색하면서 첫문자열 개수:target과 다른문자열개수:other를 셈
            여기서 현재 탐새글자에서 글자개수갱신하고 같으면 분리하고 카운트증가
            
            다음과정으로 반복.
            만약 같은개수 찾지못하고 탐색종료된다면 해당 문자열을 분리하고 카운트증가
    
        */
        
        boolean isStart = true;
        char target = ' ';
        int targetCount = 0;
        int otherCount = 0; // 초기화해야함 마지막
        for (char ch : s.toCharArray()) {
            if (isStart) {
                target = ch;
                targetCount++;
                isStart = false;
                continue;
            }
            if (ch == target) {
                targetCount++;
                if (targetCount == otherCount) {
                    isStart = true;
                    answer++;
                    targetCount = 0;
                    otherCount = 0;
                }
            } else {
                otherCount++;
                if (targetCount == otherCount) {
                    isStart = true;
                    answer++;
                    targetCount = 0;
                    otherCount = 0;
                }
            }
            
        }
        // 문자열이 남은 상태를 체크해서 answer++ 결정해야함
        if (!isStart) {
            answer++;
        }
        
        return answer;
    }
}