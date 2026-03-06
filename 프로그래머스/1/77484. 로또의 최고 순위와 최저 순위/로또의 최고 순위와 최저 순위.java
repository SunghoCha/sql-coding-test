import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        
        int zeroCount = 0;
        int correctCount = 0;
        Set<Integer> wins = Arrays.stream(win_nums)
            .boxed()
            .collect(Collectors.toCollection(HashSet::new));
        for (int i = 0; i < 6; i++) {
            int num = lottos[i];
            if (num == 0) {
                zeroCount++;
                continue;
            }
            if (wins.contains(num)) {
                correctCount++;
            }
        }
        int max = correctCount + zeroCount;
        int min = correctCount;
        
        int[] answer = new int[2];
        answer[0] = Math.min(7 - max, 6);
        answer[1] = Math.min(7 - min, 6);
        return answer;
    }
}