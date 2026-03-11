import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        /*
            단어마다 카운팅 % n 하면 몇번쨰사람인지 구해짐. 인덱스기준이면 0부터.
            카운팅 / n + 1하면 차례구해짐
            
            그냥 set에 담아놓고 contains 되는순간
        */
        String first = words[0];
        char last = first.charAt(first.length() - 1);
        Set<String> set = new HashSet<>();
        set.add(first);
       
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (set.contains(word) || word.charAt(0) != last) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            last = word.charAt(word.length() - 1);
            set.add(word);
            
        }
        return answer;
    }
}