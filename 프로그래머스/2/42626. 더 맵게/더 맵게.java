import java.util.*;
class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        /*
            minheap에서 꺼낸게 k보다 작은동안
            가장 안매운거 + 두 번쨰로 안매운거* 2로 섞어서 다시 minheap에 넣음
            
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : scoville) {
            minHeap.offer(num);
        }
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            answer++;
            int first = minHeap.poll();
            int second = minHeap.poll();
            int newNum = first + 2 * second;
            minHeap.offer(newNum);
        }
        // 만약 사이즈1이라면 k이상인지 체크해야함
        if (minHeap.size() == 1 && minHeap.peek() < k) {
            return -1;
        }
        return answer;
    }
}