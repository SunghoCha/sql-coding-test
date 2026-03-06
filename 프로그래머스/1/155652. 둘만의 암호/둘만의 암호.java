import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        
        StringBuilder sb = new StringBuilder();
        int length = 26 - skip.length();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
                
            if (skip.contains(String.valueOf(ch))) {
                continue;
            }
            sb.append(ch);  
            
        }
        String str = sb.toString();      
        sb = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            int idx = str.indexOf(ch);
            int newIdx = (idx + index) % length;
            sb.append(str.substring(newIdx, newIdx + 1));
        }        
        return sb.toString();
            
    }
}