import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        char[] doubles = new char[2 * n];
        
        for (int i = 0; i < 2 * n; i++) {
            doubles[i] = chars[i % n];
        }
        
        for (int i = 0; i < n; i++) { // 시작지점 루프
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (int j = i; j < i + n; j++) {
                char ch = doubles[j];
                if (ch == '[' || ch == '{' || ch == '(') {
                    stack.push(ch);
                    continue;
                }
                
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                
                char target = stack.pop();
                if (ch == ']' && target == '[' ||
                   ch == '}' && target == '{' ||
                   ch == ')' && target == '(') {
                    continue;
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid && stack.isEmpty()) {
                answer++;
            }
            
        }
        return answer;
    }
}