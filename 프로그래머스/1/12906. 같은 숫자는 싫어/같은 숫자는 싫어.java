import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (queue.isEmpty() || queue.peekLast() != arr[i]) {
                queue.addLast(arr[i]);
            }
        }
        int[] answer = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            answer[i] = queue.pollFirst();
            i++;
        }
        return answer;
    }
}