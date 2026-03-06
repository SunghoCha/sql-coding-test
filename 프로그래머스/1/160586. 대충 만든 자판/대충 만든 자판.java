import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, Math.min(map.getOrDefault(ch, 102), i + 1));
            }
        }
        
        int[] ans = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            String str = targets[j];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int num = map.getOrDefault(ch, 102);
                if (num == 102) {
                    ans[j] = -1;
                    break;
                } else {
                    ans[j] += num;
                }
            }
        }
        return ans;
    }

}