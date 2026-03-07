class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        /*
            일주일동안 늦지 않아야 상품
            출근희망시각 + 10분까지 허용
            주말 제외
            이벤트를 시작한 요일. 토요일과 일요일 걸러내기용으로 필요. 6,7이 주말 인덱스로는 5,6
            
        */
        
        // 인덱스는 0base, 문제는1base 주의
      

        boolean isOk = true;
        for (int i = 0; i < timelogs.length; i++) { 
            int sche = schedules[i];
            int[] timelog = timelogs[i]; 
            for (int j = 0; j < timelog.length; j++) { // 한 사람의 일주일스케줄 루프
                /*
                    주말찾아서 스킵. startday
                    j + startday -> (j + startday) % 7
                    0 + 5 -> 5 금
                    1 + 5 -> 6 토   
                    2 + 5 -> 7 일 -> 0
                    3 + 5 -> 8, 1 월
                    4 + 5 -> 9, 2 화
                    5 + 5 -> 10, 3 수
                    6 + 5 -> 11, 4 목
                    0, 6이 주말
                */
                int targetDay = (j + startday) % 7;
                if (targetDay == 0 || targetDay == 6) {
                    continue;
                }
                
              
                // sche + 10분 시간 구해야함.
                /* 958이라면? 968이되는데 그냥 계산? 1008인데 이러면 
                    1001도 허용못해버림. 968불가
                    자리수 계산해야함. 그렇다면 그냥 시간하고 분을 토탈로 계산?
                    어차피 60단위면 시간*60 + 분으로?
                */
                int limit = convertTime(sche) + 10;
                int time = convertTime(timelog[j]);
                if (time > limit) {
                    isOk = false;
                    break; // 한 번이라도 늦으면 이벤트 탈락
                }
                isOk = true;
            }
            // 다 통과했으므로 당첨
            if (isOk) {
                answer++;
            }
            
            
        }
            
        return answer;
    }   
                    
    public static int convertTime(int time) {
        /*
            분은 무조건 뒤에서부터 2자리
            시각은 1자리 or 2자리
            100으로 나눈 나머지가 분이된다.
            100으로 나는 몫이 시각이 된다.
        */
        int min = time % 100;
        int h = time / 100;
        return h * 60 + min;
    }                
}