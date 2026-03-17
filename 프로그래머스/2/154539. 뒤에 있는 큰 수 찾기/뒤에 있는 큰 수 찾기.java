import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        /*
            자신보다 뒤에있는 숫자중 자신보다 크면서 가장 가까이 있는 수 : 뒷큰수
            배열길이 100만. 시간복잡도 n^2 불가
            map에 값, 인덱스로 담자니 중복을 못담음. 가장 빠른 인덱스 담는다고 해결도 안됨.
            ex) 3,2,3인 케이스.
            정렬하면 인덱스정보가 사라지는데... 정렬해놓고 인덱스정보도 따로 보관이 가능한가?
            역순으로 하면 어떻지? 소용없어보임 마찬가지로 n^2.
            누적합같은 문제도 아니고? 
            
            스택이 비어있지않다면 peek로 자기보다 같거나 큰 값이 나올때까지 뺀다
            빼면서 자신의 값을 추가하는데 꺼내지는 수의 인덱스에 추가한다.
            반복문이 끝나고 스택에 남아있는 숫자들의 인덱스에 -1을 추가한다.
            
        */
        int[] ans = new int[numbers.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i]; //값
            while (!stack.isEmpty() && stack.peek()[1] < cur) { // 값 비교
                int[] nums = stack.pop();
                int idx = nums[0];
                ans[idx] = cur;
            } 
            stack.push(new int[]{i, cur});
        }
        while (!stack.isEmpty()) {
            int[] nums = stack.pop();    
            ans[nums[0]] = -1;
        }
        return ans;
    }
}