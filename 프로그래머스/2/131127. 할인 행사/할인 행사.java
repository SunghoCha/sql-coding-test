import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        /*
            금액지불하면 10일동안 회원자격
            회원 대상 매일 한 가지 제품 할인
            할인 제품은 하루에 하나씩만 구매 가능
            자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
            길이 10짜리 수열 안에서 원하는걸 다 찾을 수 있는 경우의 수
            길이 10짜리의 조건 만족시키는 부분수열 카운트
            조건만족체크는 어떻게? 카운팅맵?
            크기 10만이면 투포인터로 해야할듯? 
            고정크기니까 특정조건에 따라 left, right 옮길텐데..
            그냥 기계적으로 조건 만족안하면 left++ right++ 하면 그만.
            그러니까 조건체크를... 매번 맵에 있는 개수 만족하는지를 두 개의 맵으로 체크? 
            일단 해보자
        */
        Map<String, Integer> wants = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        for (int i = 0; i < 10; i++) { // 10일동안의 기록 채워넣음
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        int left = 0;
        int right = left + 9;//초과? 
        /* 구간이 10일 아래여도 찾을수만 있으면됨
            그런데 애초에 right놔두고 left 좁힌다고 만족될리없음
        */
        while (right < discount.length) { // 종료조건은 left? right?
            // 조건만족하는지 체크
            if (check(wants, map)) { // 조건만족
                answer++;            
            }
            String leftItem = discount[left];
            map.put(leftItem, map.getOrDefault(leftItem, 0) - 1);
            left++;
            right++;
            if (right < discount.length) {
                String rightItem = discount[right];
                map.put(rightItem, map.getOrDefault(rightItem, 0) + 1);
            }   
        }
        return answer;
    }
    
    public static boolean check(Map<String, Integer> wants, Map<String, Integer> map) {
        for (String key : wants.keySet()) {
            int wantsNum = wants.get(key);
            int count = map.getOrDefault(key, 0);
            if (wantsNum > count) {
                return false;
            }
        }
        return true;
    }
}