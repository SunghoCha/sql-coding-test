import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strs = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            int num = Integer.parseInt(str);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}