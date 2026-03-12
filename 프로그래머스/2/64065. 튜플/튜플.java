import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        /*
           원소개수가 적은걸로부터 순서 유추
           근데 이걸 굳이 복잡하게 스플릿으로하는게 아니고 
           그냥 중괄호제거하고 ,로 스플릿하면 하나하나의 숫자나옴
           여기서 숫자개수가 많을수록 앞에 위치하는 원소라는 뜻
        */
        Map<Integer, Integer> map = new HashMap<>();
        String[] split = s.replace("{", "").replace("}", "").split(",");
        for (String str : split) {
            int num = Integer.parseInt(str);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (int key : map.keySet()) {
            int num = map.get(key);
            int idx = size - num;
            answer[idx] = key;
        }
        return answer;
    }
}