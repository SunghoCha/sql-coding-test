import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int target = commands[i][2] - 1;
            
            List<Integer> list = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                list.add(array[j]);
            }
            list.sort((a, b) -> a - b);
        
            answer[idx++] = list.get(target);
            
        }
        return answer;
    }
}