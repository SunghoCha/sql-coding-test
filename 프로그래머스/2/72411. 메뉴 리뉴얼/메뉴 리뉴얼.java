import java.util.*;
class Solution {
    Map<String, Integer> map = new TreeMap<>();
    public String[] solution(String[] orders, int[] course) {
        /*
            코스요리는 최소 2가지 이상, 메뉴후보는 최소 2명 이상한테 주문된 단품
            가장 많이 함께 주문된 단품메뉴 조합
            
            course 숫자가 예를 들어 2면 2개의 조합
            가장많이 주문된 요리 2개?
            
            근데 따로 주문된 횟수가 아니라 "조합"으로 존재해야하네?
            orders, course 둘 다 크기는 작아서 완탐도 상관없음
            근데 27개알파벳중에 2개 3개 4개.. 10개인건데
            
            orders에 있는 알파벳중에 조합 뽑음 길이가 조건만족하는지 체크하고 만족한다면
            
        */
        List<String> list = new ArrayList<>();
        for (int cour : course) { 
            for (String order : orders) { // 코스당 조합 맵에 담기
                if (order.length() >= cour) {
                    findComb(cour, order);       
                }            
            }
            int max = Integer.MIN_VALUE;
            for (String key : map.keySet()) { // 가장 많이 함께 주문된 숫자
                if (key.length() == cour) {
                    max = Math.max(max, map.get(key));
                }
            }
            for (String key : map.keySet()) { // 가장 많이 함께 주문된 조합들 담기
                if ((key.length() == cour) && map.get(key) == max && max >= 2) {
                    list.add(key);
                }
            }
        }
        list.sort(Comparator.naturalOrder());
 
        return list.stream().toArray(String[]::new);
        
    }
    
    public void findComb(int cour, String order) {
        char[] chars = order.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        backtrack(0, cour, 0, chars, "", visited);
    }
    
    public void backtrack(int start, int cour, int depth, 
                          char[] chars, String str, boolean[] visited) {
        if (depth == cour) {
            map.put(str, map.getOrDefault(str, 0) + 1); 
            return;
        }
        
        for (int i = start; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtrack(i + 1, cour, depth + 1, chars, str + chars[i], visited);
                visited[i] = false;
            }
        }
    }
}