import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        Arrays.sort(strings, (s1, s2) -> {
            char ch1 = s1.charAt(n);
            char ch2 = s2.charAt(n);
            
            if (ch1 == ch2) {
                return s1.compareTo(s2);
            } else {
                return Character.compare(ch1, ch2);
            }
            
        });
        return strings;
    }
}