import java.util.*;
class Solution {
    List<Integer> list = new ArrayList<>();
    public int solution(int[][] jobs) {
        /*
            작업번호 요청시각 소요시간을 저장하는 대기큐 ~ 우선순위큐
            우선순위 : 소요시간'짧은것 요청시각'빠른것 작업번호'작은것
            작업 한 번 시작하면 작업을 마칠때까지 그 작업만 수행
            작업마치자마자 새로운작업들어오면 큐에넣고 꺼내서 작업수행
            모든요청작업을 마쳤을때 모든 요청의 작업반환시간을 구해서 평균의 정수부분 리턴
            
        */
        // int[] // 요청시점 소요시간 작업번호
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) { // 소요시간 같다면
                if (a[0] == b[0]) { // 요청시간도 같다면
                    return a[2] - b[2]; // 작업번호 작은것
                }
                return a[0] - b[0]; // 요청시간 빠른것
            }
            return a[1] - b[1]; // 소요시간 짧은것
        });
        /*
            현재 작업에 대해 수행하는것들
            현재작업중인것이 없는 경우
             - 우선순위큐에넣고 꺼내서 작업 수행
             - 작업수행되면 끝나는시간체크가능. 현재시각 + 소요시간 - 요청시각
             큐에 들어갈때 해당작업의 요청시각, 소요시간정보있음
             i번째 요청시각이 현재시각
            현재작업중인것이 있는 경우
             - 우선순위큐에 넣음
             
             ==> 그래서 문제는 현재작업중인것이 있는지 없는지 어떻게 알지?
             
             관점을 바꿔야하는듯
             이벤트시뮬레이션에선 이벤트 발생 시점 기준으로 선택이 필요한 순간만 보면됨
             이 문제에서 그 순간은? 작업이 들어오는 요청시각이 그걸 보장하지않음
             한 번 선택된 작업은 끝까지 처리되고 그다음엔 우선순위에 따라 결정되기 때문.
             그렇다면 선택이 필요한 순간은? 한 작업이 끝난 시각의 상황. 그때의 선택.
             
             작업을 끝낸 시각
             그 시각보다 빠른 요청 시각들을 이떄 찾아서 우선순위 큐에넣고 다시 꺼내서 작업
             
             이 루프를 반복하는 흐름. 구간을 잘 나눠서 루프.
             근데 항상 헷갈리는게 맨처음 작업을 while안으로 자연스럽게 넣는게 어려움..
        */
        
        Arrays.sort(jobs, (a, b) -> { // 요청시각 빠른순
            return a[0] - b[0];
        });
        
        int currentTime = 0;
        int n = jobs.length;
        int done = 0;
        int idx = 0;
        while (done < n) { // done은 처리된 작업수
            
            while (idx < n) { // currentTime보다 작은 요청시각을 가진것들을 꺼내서 우선순위 큐에 넣기
                int requestTime = jobs[idx][0];
                if (requestTime > currentTime) {
                    break;
                }
                // 요청시각 소요시간 작업번호

                queue.offer(new int[]{jobs[idx][0], jobs[idx][1] ,idx});
                idx++;
            }
            if (queue.isEmpty()) {
                currentTime = jobs[idx][0];
                continue;
            }
                
            int[] cur = queue.poll(); // 우선순위 작업 꺼냄
            int req = cur[0]; // 요청시각
            int peri = cur[1]; // 소요시간
            int num = cur[2]; // 작업번호
            int convertTime = currentTime + peri - req; // 한 작업의 소요시간

            list.add(convertTime); 
            currentTime += peri; // 작업 후 시간으로 갱신
            done++; // 작업완료 1개 추가
        }
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }
        answer /= list.size();
        return answer;
    }
}