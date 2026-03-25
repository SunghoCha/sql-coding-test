import java.util.*;
class Solution {
    public int solution(int storey) {
        /*
            일의자리숫자부터 그라디하게 품
            값 갱신해야함. 엘리베이터가 매순간 위아래로 움직이는것 표현
            *현재숫자 5일땐 다음윗자리수의 영향받음
            올릴떈 앞자리수 갱신
        */
        int ans = 0;
        while (storey > 0) {
             // 0인지 아닌지 체크?
            int cur = storey % 10;    
            if (cur == 5) {
                int pre = (storey % 100) / 10;    
                if (pre >= 5) { // 올림
                    ans += (10 - cur);
                    storey += 10; // 자리수를 계속 줄이니까 이걸로 충분?
                } else { // 내림
                    ans += cur;
                }
            } else if (cur > 5) {
                ans += (10 - cur);
                storey += 10;
            } else if (cur < 5) {
                ans += cur;
            } 
            storey /= 10;
        }
        return ans;
    }
}