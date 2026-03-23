import java.util.*;
class Solution {
    public int solution(int length, int limit, int[] trucks) {
        int answer = 0;
        /*
            최대 올라갈 수 있는 대수, 최대무게
            다리에 완전히? 오르지 않은 트럭 무게는 무시
            다리를 정해진 순서로 건너는거라서 보트무게 문제랑 다름
            그라디는 아닌건지 체크해보기
            다리 건너는대 1초 소요?
            대기 -> 다리 위 가는데 1초
            다리 위 -> 다리 밖 1초
            다리 위에 한대씩 올라감. 한 번에 올라가는것도 아님
            
            다리 위 올라갈떄 체크해야할것
            다리 사이즈, 다리 총무게
            큐 자료구조 이용?
            큐에 조건에 따라 추가하고 초마다 poll은 고정.
            넣을떄만 조건체크. 
            큐에 들어갈때 무게 항상 갱신을 위한 필드
            
            비어있지않으면 poll고정
            허용되면 offer
            
            근데 비어있지않으면 poll먼저해야할듯
            
            
            반복문으로 구현가능한가?
            조건 만족안하면 다음반복문으로 가면 이번 트럭스킵인데? 이게 반복문으로 되는건가
            
            그냥 큐 두개로하는게?
            간과한게 있음 length는 단순히 다리에 들어올 수 있는 차 개수가 아니고
            길이 개념도 있음...
        */
        
        
        Deque<Integer> bridge = new ArrayDeque<>();
        Deque<Integer> wait = new ArrayDeque<>();
        // 초기값 설정
        for (int i = 0; i < length; i++) {
            bridge.offer(0);
        }
        for (int truck : trucks) {
            wait.offer(truck);
        }
        int curW = 0;
        int time = 0;
        while (!(bridge.isEmpty() && wait.isEmpty())) {
            if (!bridge.isEmpty()) { 
                int outTruck = bridge.poll(); // 다리 통과 (처음엔 0)
                curW -= outTruck; // 다리 무게 갱신
            }
            if (!wait.isEmpty()) { 
                if (bridge.size() < length && limit >= curW + wait.peek()) {
                    int inTruck = wait.poll(); // 대기 출차
                    bridge.offer(inTruck); // 다리 입차
                    curW += inTruck; // 다리 무게 갱신
                } else {
                    bridge.offer(0);
                }
            }
            time++;
        }
        
        return time;
    }
    
  
}