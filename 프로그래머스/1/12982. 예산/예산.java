import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        
        int i = 0;
        while (i < d.length && budget >= d[i]) {
            budget -= d[i];
            answer++;
            i++;
        }
        return answer;
    }
            // for (int i = 0; i < d.length; i++) {
        //     if (budget < d[i]) {
        //         break;
        //     } 
        //     budget -= d[i];
        //     answer++;
        // }
        // return answer;
}