import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        list.sort((a, b) -> a - b);
        if (list.isEmpty()) {
            return new int[]{-1};    
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}