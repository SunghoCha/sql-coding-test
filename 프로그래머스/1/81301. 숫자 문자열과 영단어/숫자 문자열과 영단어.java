import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
                continue;
            }
            
            String target = sb.append(ch).toString();

            if (map.containsKey(target)) {
                String str = map.get(target);
                result.append(str);
                sb.setLength(0);
            }
            
        }
        return Integer.parseInt(result.toString());
    }
}