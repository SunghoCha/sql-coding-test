import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
                
            }
            
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

        
    }
}