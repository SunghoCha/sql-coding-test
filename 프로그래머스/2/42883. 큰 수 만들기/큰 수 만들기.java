import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        /*
            100만 자리수에서 k자리수 제거했을때 가장 큰수
            n개 중에서 n - k개를 선택해서 만들 수 있는 가장 큰 수
            조합이나 순열로하면 ~ n^2 수준 시간복잡도라 불가능. 그리고 순서도 정해져있어서 이건아닌듯
            자리수는 정해져있음.
            가장 왼쪽에 있는 작은수를 제거해야함
            근데 작은수의 기준이?
            2222111 이런식이면 2가작은수여도 뒤에있는 1보다는 상대적으로 커서 제거하면 안됨...
            당장의 숫자만 봐선 이게 "상대적으로" 작은지 큰지몰라서 그라디는 불가능?
            
            당장의 숫자와 바로 왼쪽숫자만봐도 가능하다는 리뷰...
            생각치못했는데 이 방식이면 그라디가 맞는듯..
            왜 이 생각을 못했지? 어떤 무의식적 직관이 방해한거지?
            
            이 힌트받고도 원하는 숫자만 필터링해서 저정하는걸 못 떠올림
            리스트를 떠올려서 contains나 remove하는 방식이라 시간초과...
            스택으로 원하는것만 담도록 구현했어야 했음
            
            스택 peek해서 자기보다 작으면 k개수 체크하고 pop
            push는 디폴트
        */
        char[] chars = number.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) { // 마지막 수 제외
            int curNum = Character.getNumericValue(chars[i]);
            while (!stack.isEmpty() && count < k) {
                if (curNum > stack.peek() && count < k) {
                    stack.pop();
                    count++;
                } else {
                    break;
                }
            }  
            stack.push(curNum);
        }
        
        while (count < k) {
            stack.pop();
            count++;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
    
        return sb.toString();
    }
}