import java.util.*;
class Solution {
    
    public static char[] chars;
    public static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        
        chars = numbers.toCharArray();
        int length = chars.length;
        boolean[] visited = new boolean[length];
        /*
            조합으로 만들어진 스트링을 Integer로 변환하고 소수인지 체크
            "조합"을 위한 백트래킹
            numbers에 중복숫자 있어서 중복된 케이스 있으니 Set에 담아서 size반환
            
            조합이 아닌 순열임..
        */
        String str = "";
        backtrack(visited, 0, length, str);
        return set.size();
    }
    
    public void backtrack(boolean[] visited, int depth, int length, String str) {
    
        if (!str.equals("") && isPrime(str)) {
            set.add(Integer.parseInt(str));
            
        }
        
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                backtrack(visited, depth + 1, length, str + chars[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(String str) {
        int num = Integer.parseInt(str);
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}