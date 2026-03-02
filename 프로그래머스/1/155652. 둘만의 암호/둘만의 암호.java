import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] list = new char[26];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            list[i] = (char) (i + 'a');
            map.put((char) (i + 'a'), i);
        }
        
        /*
            근데 매번 탐색하면서 스킵리스트인지 세야하나? 스킵의 숫자 미리 계산해놓고?
        */
        Set<Character> skipSet = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        for (char ch : s.toCharArray()) {
            int num = map.get(ch);
            int count = index;
            
            /*
                idx만큼가야하는데
                스킵리스트면 idx 늘리지않아아야함
                처음에 이미 1증가한상태로 들어와서 포함안되면 인덱스증가
                
            */
            int idx = 1;        
            while (count != 0) { // 처음에 이미 1증가한 상태로
                if (skipSet.contains(list[(num + idx) % 26])) {
                    idx++;
                    continue;
                }
                idx++;
                count--;            
            }
            // idx - 1값 사용해야함
            answer += list[(num + idx - 1) % 26];
        }
        
        return answer;
    }
}