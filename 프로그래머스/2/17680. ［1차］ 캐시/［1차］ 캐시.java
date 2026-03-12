import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        /*
            캐시방식은 LRU. LRU 방식이면 큐에서 꺼내서 다시 넣는 방식?
            
            contains remove offer
            cities를 순회하면서 캐시에 있는지 확인한다.
            있으면 제거하고 뒤에 다시 넣는다. 시간 +1 추가
            없으면 poll로 하나 제거후에 offer한다 시간+5추가
            이 과정을 계속 반복한다. cites for문으로 될 듯
        */
        Deque<String> queue = new ArrayDeque<>();
        int length = cities.length;
        if (cacheSize == 0) {
            return length * 5;
        }
        for (int i = 0; i < length; i++) {
            String city = cities[i].toUpperCase();
            if (queue.contains(city)) {
                queue.remove(city);
                queue.offer(city);
                answer += 1;
            } else {
                if (queue.size() == cacheSize) {
                    queue.poll();
                    queue.offer(city);
                } else {
                    queue.offer(city);
                }
                answer += 5;
            }
        }
        
        
        
        return answer;
    }
}