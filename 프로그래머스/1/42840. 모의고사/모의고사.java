import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] result = new int[3];
        for (int i = 0; i < answers.length; i++) {
            int idx1 = i % a1.length;
            int idx2 = i % a2.length;
            int idx3 = i % a3.length;
            
            if (answers[i] == a1[idx1]) {
                result[0]++;
            }
            if (answers[i] == a2[idx2]) {
                result[1]++;
            }
            if (answers[i] == a3[idx3]) {
                result[2]++;
            }
        }
        int maxScore = Math.max(Math.max(result[0], result[1]), result[2]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == maxScore) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i) + 1;
        }
        return answer;
    }
}