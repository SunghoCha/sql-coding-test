import java.util.*;
class Solution {
    
    public String solution(String p) {
        
        /*
            개수만 맞으면 "균형잡힌"
            개수, 짝 둘 다 맞으면 "올바른"
            "균형 잡힌" -> "올바른"
            
            엣지케이스
            - 빈 문자열 반환
            
            균형잡힌 문자열 w를 두 개의 균형잡힌 문자열 u ,v로 분리
            단 u는 더이상 균형잡힌 문자열로 분리 불가능. v는 빈 문자열가능
            if u가 "올바른"이라면 v에 대해 1단계부터 다시 수행 (while문에서 continue거나?)
            else
            빈 문자열에 첫번쨰 문자로 "("를 붙인다?
            갑자기 빈문자열이 디폴트로 있는? 우선 앞부분 구현하고 이걸 확인해볼까?
            
            
             분리메서드(w) -> u,v 얻음
             if (u == 올바른문자열) {
                
             }
        */
        if (p.equals("")) {
            return "";
        }
        // 균형잡힌문자열 u,v로 분리 u는 더이상분리 안되는.. while? 
        // 그렇다면 왼쪽부터 스캔하면서 최초로 갯수맞으면 그 인덱스 기준으로 substring?
        char[] chars = p.toCharArray();
        int i = getIdx(chars);

        String u = p.substring(0, i + 1); // 0 ~ i까지
        String v = p.substring(i + 1); // i + 1부터 끝까지. i가 끝까지 도달하면 빈문자열
        
        // u, v 외 별도 변수분리해야하는지 체크
        if (checkGood(u)) {
            return u + solution(v);            
        } else {
            StringBuilder sb = new StringBuilder();
            return sb.append("(").append(solution(v)).append(")")
                .append(convertAndReverse(u)).toString();
        }
        
        
    }
    
    public String convertAndReverse(String u) {
        int length =  u.length();
        return u.substring(1, length - 1)
            .replace("(", "a")
            .replace(")", "(")
            .replace("a", ")");
        
    }
    
    public int getIdx(char[] chars) {
        int countL = 0;
        int countR = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                countL++;
            } else if (ch == ')') {
                countR++;
            }
            
            if (countL == countR) {
                return i;
            }
        }
        System.out.println("=============== 버그체크용");
        return -1;
    }
    
    public boolean checkGood(String str) {
        char[] chars = str.toCharArray();
        /*
            올바른 문자열 체크해야함
            스택필요?
        */
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.poll() != '(') {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}