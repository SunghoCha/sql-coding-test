import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String str : operations) {
            if (str.equals("D 1")) {
                if (!map.isEmpty()) {
                    int key = map.lastKey();   
                    int value = map.get(key);
                    if (value == 1) {
                        map.remove(key);
                    } else { // 1보다 큼
                        map.put(key, map.get(key) - 1);
                    }
                }
            } else if (str.equals("D -1")) {
                if (!map.isEmpty()) {
                    int key = map.firstKey();
                    int value = map.get(key);
                    if (value == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            } else {
                String[] split = str.split(" ");
                int num = Integer.parseInt(split[1]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        if (map.size() == 0) {
            return new int[]{0,0};
        } else {
            int min = map.firstKey();
            int max = map.lastKey();
            return new int[]{max, min};
        }

    }
}