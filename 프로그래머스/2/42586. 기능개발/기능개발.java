import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        /*
            progresses에는 인덱스가 배포순서. 값은 작업진도
            speeds는 개발속도
            각 배포마다 몇 개의 기능이 배포되는지 리턴
            progresses 자체가 배열로 구현한 큐로 동작가능할듯?
            앞에서부터 100 - 값 / 스피드로 일 수 구하고 이걸
            전체에 적용해서 100 초과한것들 다 빼고 포인터갱신
            최초 포인터는 0
            포인터가 length - 1을 초과하기전까지 수행
            한 번의 수행에서 포인터가 여러칸 움직일수도 있으므로 for문보단 while이 자연스러울듯
        */
        int pointer = 0;
        int length = progresses.length;
        List<Integer> list = new ArrayList<>();
        while (pointer < length) { // 작업진도는 100미만이니까 처음부터 100인 상황은 무시
            int job = progresses[pointer];
            int gap = 100 - job;
            int period = (int) Math.ceil((double)gap / speeds[pointer]); 
            // 몫 + 나머지 처리해야함
            
            for (int i = pointer; i < length; i++) { // pointer다음부터 뒤쪽 작업
                progresses[i] += period * speeds[i];
            } // 작업물들 갱신. 이제 100 이상인것들 꺼내면서 카운팅해야하는데 "연속" 체크 중요
            

            int count = 0;
            while (pointer < length) {
                if (progresses[pointer] >= 100) {
                    count++;
                } else {

                    break; // break되면서 포인터갱신 안되는데 문제없나?
                }
                pointer++;
            }
            list.add(count);
        }
        
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}