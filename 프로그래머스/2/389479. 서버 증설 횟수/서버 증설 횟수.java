import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        /*
            좀 특이한게 기본서버가 1대 있는데 m "미만"일때 버팀 다음부턴 m명씩
            현재 게임 이용자수와 증설된 서버수의 수를 참고하여 더 증설할지를 결정
            이용자수를 m으로 나눈 몫만큼의 증설서버가 필요
            현재 증설된 서버가 존재한다면 필요증설서버 - 현재증설서버
            총 증설된 서버의 수를 구하라
            
            상태
                현재 증설된 서버 수
                증설 횟수
                시각별로 시뮬레이션 24시간이라 점프안하고 그냥해도 될 듯?
                
                시간 지날때마다 서버가 꺼지는걸 체크 먼저하고 현재증설서버 업데이트
                현재 이용자수 기반으로 필요증설서버 구하고 추가 증설 필요여부 체크
                
                서버는 한번에 1대에서 여러대 증설가능한데..
                이 서버는 종료시간을 상태로가져야함. 증설개수까지넣어서 하나의 객체로 표현?
                근데 서버를 이렇게 따로 표현안하고 묶어서하는게 좋은게맞나?
                서버종료가 얼마안남은것부터 위로오게하려면 민힙에 넣어야할거같은데..
                서버를 따로 표현하면 민힙사이즈가 현재증설서버대수가 되는데..
                서버를 같이 표현하면 불가능.. 다 꺼내서 확인도 말이 안되고..
                이럴거면 그냥 서버는 종료시간만 의미하도록하고 while로 현재시간맞춰서 다 꺼내고
                종료처리를 의미하도록 하면 될 듯? 이러면 서버객체도 필요없고 그냥 Integer로 가능?
        */
        int ans = 0;
        PriorityQueue<Integer> pri = new PriorityQueue<>(); // 종료시간
         // 0 ~ 23까지하면 될 듯. 근데 알아서 24개인듯
        for (int time = 0; time < 24; time++) { 
            int player = players[time];
            // 현재 서버 체크
            int serverCount = 0;

            while (!pri.isEmpty() && pri.peek() <= time) { // 종료시간이므로 "="도 포함
                pri.poll();
            }        
          
            // 이용자수 체크
            int need = player / m; // 목을 제외한 나머지는 기본서버로 커버
            if (need > pri.size()) {  
                int plus = need - pri.size();
                ans += plus;
                for (int i = 0; i < plus; i++) { // 필요한 서버대수만큼 추가
                    pri.offer(time + k);
                }
            }
             
        }
              
        return ans;
    }
    

}