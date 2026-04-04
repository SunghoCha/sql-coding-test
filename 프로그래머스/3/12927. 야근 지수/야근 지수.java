import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        /*
            야근 피로도는 야근을 시작한 시점에서 남은일의 작업량이 제곱해서 더한값
            n시간동안 피로도를 최소화하도록 일함
            1시간동안 작업량 1만큼 처리
            퇴근까지 남은 n시간. 각 일에 대한 작업량 works
            
            works에서 n만큼 빼고 남은 works들의 제곱의 합이 최소가 되도록하기
            works의 길이는 최대 2만, 원소는 50000 이하. long타입
            작업시간은 최대 100만
            
            제곱을 줄여야하는건데 직관적으로 큰수일수록 제곱효과가 큼
            혹시 내림차순 정렬? 그런데 큰수에 모든 시간 투자할수도없음. 이게 중요한듯
            여기에 어떤 원칙을 적용해서 깎나?
            예를 들면 자기보다 바로 다음으로 작은 수와 같은동안 깎으면 되지않나?
            
            리뷰받음
            우선순위큐를 쓰면 바로 해결되는 문제였는데 왜 못떠올렸을까..
    
        */
        PriorityQueue<Integer> pri = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) {
            pri.offer(work);
        }
        while (n > 0 && !pri.isEmpty()) {
            int num = pri.poll();
            num -= 1;
            if (num > 0) {
                pri.offer(num);
            }
            n--;
        }
        long answer = 0;
        for (int num : pri) {
            answer += ((long) num) * num;               
        }
        
        
        
        return answer;
    }
}