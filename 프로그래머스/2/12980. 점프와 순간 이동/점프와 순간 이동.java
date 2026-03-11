import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        /*
            k칸 앞으로 점프 , or 현재까지 온 거리 * 2
            k칸 점프할때마다 건전지 소모. 순간이동이 효율적. 점프는 최소한으로.
            역산으로 해야하나? 주어진 수가 홀수면 -1해서 짝수로만들고 짝수면 기존 숫자.
            반으로 나누면서? 
            나누다가 홀수가 나오는 지점을 만나면 -1해서 다시 짝수로 만들고 반복?
            6 -> 3 -1 -> 1-0 -> 0
            5 - 1 -> 2 -> 1-0 -> 0
        */
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1) / 2;
                ans++;
            }
        }
        
        return ans;
    }
}