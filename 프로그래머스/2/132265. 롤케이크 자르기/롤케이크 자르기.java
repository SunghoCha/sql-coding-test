import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        /*
            잘린 조각크기 , 토핑개수 상관 x
            동일한 가짓수의 토핑이 되도록 자르는 경우의 수
            배열의 순서가 중요함. 길이는 100만.
            set이나 map을 이용하나?
            전체 가지수 파악한다음에
            set으로 왼쪽부터 담다가 전체 가지수가되는 순간 나머지로 달성가능하다면?
            map으로해서 size로?
            전체 카운팅맵을 먼저 만들고
            다른 맵으로 map.size가 같아지는 순간. 카운팅맵과 대조하나?
            근데 이렇게해서 조건충족안된다고 결정되는게아님. 다시 스캔하면서 확인해야하는..
            
            그러면 전체 카운팅맵하나만들고 토핑스캔하면서 값 --하다가 0되면 remove?
            근데 map.size가 절반인건 답과 상관없음
            1,2,3 과 1,2,4도 정답임. 한쪽에만 있어야하는게 아닌..
            어쨋든 토핑스캔하면서 set에 담고 0일떄 카운팅맵 제거하면서
            매번 set.size() == map.size() 비교하면?
        */
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : topping) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : topping) {
            set.add(num);
            int count = map.getOrDefault(num, 0);
            if (count == 1 || count == 0) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
            if (set.size() == map.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}