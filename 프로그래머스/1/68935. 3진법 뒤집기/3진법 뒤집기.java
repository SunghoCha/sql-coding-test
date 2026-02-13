import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % 3); 
            n /= 3; 
        }
        String str = sb.toString();
        int idx = str.length() - 1;
        int i = 0;
        while (idx >= 0) {
            answer += (int) Math.pow(3, i) * (str.charAt(idx) - '0');
            idx--;
            i++;
        }
        return answer;
    }
}