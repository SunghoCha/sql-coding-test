import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 트럭의 상태를 캡슐화한 도메인 객체
    class Truck {
        int weight;
        int exitTime;

        Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int pointer = 0;
        int curWeight = 0;
        int time = 0;

        // 대기열에 트럭이 있거나, 다리 위에 트럭이 남아있을 때까지 시계는 돈다
        while (pointer < truck_weights.length || !bridge.isEmpty()) {
            time++; // 1. 무조건 1초를 흐르게 함 (틱 진행)

            // 2. 출차 이벤트 검사 (상태: 다리 위 -> 지남)
            if (!bridge.isEmpty() && bridge.peek().exitTime == time) {
                Truck finishedTruck = bridge.poll();
                curWeight -= finishedTruck.weight;
            }

            // 3. 입차 이벤트 검사 (상태: 대기 -> 다리 위)
            if (pointer < truck_weights.length) {
                int nextTruckWeight = truck_weights[pointer];

                // 입차 조건: 다리 하중 제한 통과 & 다리 길이(수용량) 통과
                if (curWeight + nextTruckWeight <= weight && bridge.size() < bridge_length) {
                    // 입차 액션: 현재 시간에 다리 길이를 더해 출차 예정 시간을 확정함
                    bridge.offer(new Truck(nextTruckWeight, time + bridge_length));
                    curWeight += nextTruckWeight;
                    pointer++;
                } else {
                    // 타임 점프 액션: 대기 트럭이 있지만 꽉 막혀서 못 들어갈 때
                    // 다음 트럭이 빠져나갈 시간으로 단숨에 점프 (다음 루프의 time++를 고려해 -1)
                    if (!bridge.isEmpty()) {
                        time = bridge.peek().exitTime - 1;
                    }
                }
            } else {
                // 타임 점프 액션 (최적화): 대기열은 텅 비었고 다리 위에만 트럭이 남았을 때
                // 1초씩 기다릴 필요 없이 가장 앞 트럭이 나갈 시간으로 계속 점프
                if (!bridge.isEmpty()) {
                    time = bridge.peek().exitTime - 1;
                }
            }
        }

        // 큐가 완전히 비고, 모든 트럭이 다리를 빠져나왔을 때의 누적 시간이 곧 정답
        return time;
    }
}