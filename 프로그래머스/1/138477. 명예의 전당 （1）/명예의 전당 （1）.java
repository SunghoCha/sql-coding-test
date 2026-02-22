import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 넣기전에 개수체크 k개인지.
        // 새로운값이 오자마자 k이면 일단 하나 빼서 제거하고 넣은후에 다시 뺌 
        for (int i = 0 ; i < score.length; i++) {
            minHeap.offer(score[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            int result = minHeap.peek();
            answer[i] = result;
        }
        
        return answer;
    }
}