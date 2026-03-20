import java.util.*;
class Solution {
    public int solution(int[] orders) {
        int answer = 0;
        /*
            보조컨테이너는 스택처럼 동작하는듯?
            컨테이너밸트에는 1,2,3.. 순서대로 옴
            원하는 숫자올때까지 스택에 쌓음
            원하는 숫자 빼고 그다음 원하는 숫자를 찾아야 하는 위치는
            두 군데가 됨.
            그러면 처음은 어떻게 처리하지? 처음도 중간로직에 흡수시킬수있나?
            그냥 전부 다 스택과 컨테이너밸트 확인하고 둘 다 없으면 계속 스택에 넣나?
            근데 원하는게 이미 스택 중간에 섞여있는 케이스는 어떻게 판단?
            그냥 컨테이너밸트에서 끝까지 찾는식으로하고 끝에 도달하도록하나?
            이렇게 안하면 스택에 넣는걸 다 일일이 추적해야하니 안되는거고?
            근데 컨테이너에 담긴 숫자가 랜덤이 아니고 1 부터 순서대로니까 끝까지 안가도 알 수 있는거
            아닌가? 컨테이너 숫자가 이미 찾는 숫자보다 크면 스택에 있다는건데 스택에서 못꺼내면 끝이니까?
            
            로직을 다시 정리하면
            if 컨테이너에서 찾음. 이건 포인터 하나로 1부터 다루면됨
            포인터가 찾는값이 아니면 스택에서 먼저 있는지 확인
            if 있으면 꺼냄. 없으면 .스택에 넣고 포인터증가(컨테이너밸트 다음 물건 가리킴)
            그리고 다음 
            
        
        */
        
        int pointer = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int order : orders) {
            if (pointer == order) {
                pointer++;
                answer++;
                continue;
            } else if (!stack.isEmpty() && stack.peek() == order) { 
                stack.pop();
                answer++;
                continue;
            }  
            while (order > pointer) {
                stack.push(pointer);
                pointer++;
            }
            
            if (order == pointer) {
                pointer++;
                answer++;
            } else {
                break;
            }
            // 여기서 order == pointer가 아니고 이미 order가 pointer보다 크면 끝
        }
        return answer;
    }
}