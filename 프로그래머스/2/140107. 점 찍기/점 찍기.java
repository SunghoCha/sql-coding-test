import java.util.*;
class Solution {
    public long solution(int k, int d) {
        /*
            k의 배수만큼 x, y좌표에 점찍기
            k 최대 100만 d 최대 100만
            k가 1이면 거의 1억개? 완탐으로 못 찍음
            이런건 자료구조보다는 수학공식 세워서 푸는 문제같은데
            각 x지점에서 가능한 최대 y값 구하고 가능한 개수 구함
            x2 + y2 = d2
            y2 = d2 - x2 -> y = sprt(d2 - x2)
        */
        long count = 0L;
        for (long x = 0; x <= d; x = x + k) {
            long y = (long) Math.sqrt((long)d * d - x * x); // 알아서 내림처리?
            count += y / k + 1;    
        }

        return count;
    }
}