import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        /*
            priorities는 중요도 참고용 배열로 놔두고 별도의 큐를 이용한다.
            그래도 일단 priorities를 순서대로 큐에 담아서 초기화. 그 이후에는 중요도 참조용
            큐에는 인덱스 정보가 담기고 이걸로 priorities를 참조
        
        */
        int length = priorities.length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (hasPrior(priorities, queue, idx)) {
                queue.offer(idx);
            } else {
                answer++;
                if (idx == location) {
                    return answer;
                }
            }
            
        }
        
        return answer;
    }
    
    public boolean hasPrior(int[] priorities, Deque<Integer> queue, int idx) {
        for (int num : queue) {
            if (priorities[num] > priorities[idx]) {
                return true;
            }
        }
        return false;
    }

}