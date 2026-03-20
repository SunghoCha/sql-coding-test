import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        /*
            완전탐색으로하면 n^2인데 10만 제곱이라 시간초과
            보통 얼마까지 가능하지? 1000의 제곱스케일까지 된다고 봐야하나?
            
            각 요소들은 자기이전은 신경쓰지않아도 됨
            하지만 자기 뒤에 있는 요소들의 순서는 신경써야함
            근데 이후 요소를 신경쓰려면 요소들을 우선 다 담고나서 생각?
            큐 구조에서 하게될듯.. 근데 그 이후 요소들 체크하는거면
            이건 완전탐색하고 다를게없는데?
            
            스택에 담다가 비어있지않을떄 peek로 자기보다 작은지 아닌지에 따라 달라짐
            크면 그냥 담음. 작으면 계속 빼면서 인덱스차이 배열에 추가.
            이 과정은 자기보다 작지않을때까지.
            2가지 방식 고민
            일단 스택에 다 담고나서 포인터두고 할까?
            아니면 반복문으로?
        */
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;                     
            }
            
            stack.push(i);                          
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices.length - idx - 1;
        }
        return ans;
    }
}