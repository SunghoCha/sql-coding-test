import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        char[] doubles = new char[2 * n];
        char[] chars = s.toCharArray();
        for (int i = 0; i < 2 * n; i++) {
            doubles[i] = chars[i % n]; 
        }
        /*
            i: 0 ~ n - 1 까지 이동시키면서 사이즈 n짜리 윈도우에 대해서 스택으로 대칭 검증
        */
        for (int i = 0; i < n; i++) { // 시작 인덱스
            boolean isOk = true;
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                
                char ch = doubles[j];
                if (ch =='[' || ch == '{' || ch == '(') {
                    stack.push(ch);
                    continue;
                }
                if (stack.isEmpty()) {
                    isOk = false;
                    break;    
                }
         
                char target = stack.pop();
                if (ch == ']' && target != '['
                   || ch == '}' && target != '{'
                   || ch == ')' && target != '(') {
                    isOk = false;
                    break;
                } 
            }
            
            if (isOk && stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}