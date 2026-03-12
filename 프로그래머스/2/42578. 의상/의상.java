import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        /*
            0 1 2
            0 1 -> 3 * 2 - 1
            종류별로 맵에 저장한다음에 다 곱하고 - 1?
            근데 종류별로 저장할떄 특정 종류에서 같은건지 구분해야함
            그렇다면 map안에 set으로 이중구조?
        */
        Map<String, Set<String>> map = new HashMap<>();
        // category,
        for (int i = 0; i < clothes.length; i++) {
            String item = clothes[i][0];
            String category = clothes[i][1];
            map.computeIfAbsent(category, k -> new HashSet<>()).add(item);
        }
        int sum = 1;
        for (String key : map.keySet()) {
            sum *= (map.get(key).size() + 1);
        }
        return sum - 1;
    }
}