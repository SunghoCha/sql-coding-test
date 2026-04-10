import java.util.*;
class Solution {
    public String solution(String playtime, String advtime, String[] logs) {
        
        /*
            동영상 재생시간길이 play
            광고 재생시간길이 adv
            시청자 재생로그 logs
            누적재생시간 가장 큰 광고시작시간구하기. 타이라면가장 빠른 시각 반환
            
            log 개수 30만
            초단위로 하면 시각도 대략 30-40만?
            초단위 완탐 불가능. 분명 특정 시각에서 계산하겠지만 어쨌든 겹치는 시각 구하는건 동일
            
            겹치는 시각 찾는 메서드 먼저 생각?
            보통 일부구간이 겹칠텐데 어떻게 계산?
            설명에서처럼 개수를 곱하는식으로 할까 과연? 그냥 말이 안되는 트릭같음
            
            리뷰받음
            고정길이구간을 어디에 둬야 누적시간이 최대인가?
            
            그러면 이 고정길이를 초단위로 옮기면서 계산?
            log들은 결국 일직선좌표상에 늘어선 값들. 1,3,5,2,1,6,10, ... f(t)
            이걸 고정윈도우로 최대값을 구하는 문제일뿐
            그러면 이건 단순한 투포인터 윈도우 문제?
            근데 f(t)를 만들때 로그구간마다 루프돌면 최대 30만 * 36만이라 불가능..
            차분배열 사용해야함
            diff[]를 만들고 이를 반영한 배열만들어야함
            로그시작구간에서 +1 로그끝나는구간에서 -1
        */
        int play = convertTime(playtime);
        int[] view = new int[play + 1];
        for (String log : logs) {
            String[] split = log.split("-");
            int start = convertTime(split[0]);
            int end = convertTime(split[1]);
            view[start]++;
            view[end]--;
        }
        for (int i = 1; i < play + 1; i++) {
            view[i] += view[i - 1];
        }
        // f(t) = view
        int adv = convertTime(advtime);

        long sum = 0;
        /*
            view[i]는 [i, i+1) 동안의 시청수
            0 ~ adv는 view[0] + ... + view[adv - 1]
        */
        for (int i = 0; i < adv; i++) {
            sum += view[i];
        }
        int answer = 0;;
        long max = sum;
        int left = 0;
        int right = adv; // 반열린구간 [) 
        while (right <= play) {
            sum -= view[left];
            sum += view[right];
            if (sum > max) {
                max = sum;
                answer = left + 1;
            }
            left++;
            right++;
        }
        return convertToStr(answer);
        
        
        
        
    }
    
    public String convertToStr(int answer) {
        int hh = answer / 3600;
        answer %= 3600;
        int mm = answer / 60;
        answer %= 60;
        int ss = answer;
        return String.format("%02d:%02d:%02d", hh, mm, ss);
        
    }
    
    public int convertTime(String time) {
        String[] split = time.split(":");
        int hh = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        int ss = Integer.parseInt(split[2]);
        
        return 3600 * hh + 60 * mm + ss;
    }
}