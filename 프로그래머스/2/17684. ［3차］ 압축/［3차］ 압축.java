import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        List<Integer> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'A');
            list.add(String.valueOf(ch));
            map.put(String.valueOf(ch), i); // 0-base
        }
        
        String target = "";
        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String str = String.valueOf(msg.charAt(i)); // k, a
            String newTarget = sb.append(target).append(str).toString(); // ka
            if (!list.contains(newTarget)) {
                int idx = map.get(target); // 11
                result.add(idx + 1); // 색인출력, 1-base
                list.add(newTarget); // 사전등록
                map.put(newTarget, list.size() - 1); // 인덱스 기준 등록
                target = str; // 현재 문자열로 초기화
            } else { // newTarget을 포함하고 있음
                target = newTarget; // k
            }
        }
        int idx = map.get(target);
        result.add(idx + 1);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
        
    }
}