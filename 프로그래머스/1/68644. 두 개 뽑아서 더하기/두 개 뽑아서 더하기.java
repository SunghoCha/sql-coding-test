import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int length = numbers.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int a = numbers[i];    
                int b = numbers[j];
                int result = a + b;
                if (!set.contains(result)) {
                    set.add(result);
                    list.add(result);
                }
            }   
            
        }
        list.sort((a, b) -> a - b);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);    
        }
        return answer;
    }
}