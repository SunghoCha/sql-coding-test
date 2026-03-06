import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>(); // 카운팅 맵
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        for (int i = 0; i < participant.length; i++) {
            String target = participant[i];
            if (!map.containsKey(target)) {
                return target;
            }
            map.put(target, map.get(target) - 1);
        }
        
        for (String str : map.keySet()) {
            if (map.get(str) != 0) {
                return str;
            }
        }
        return answer;
    }
}