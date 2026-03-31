import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        
        /*
            경계값 포함
            sqrt(x^2 + y^2) >= r1
            sqrt(x^2 + y^2) <= r2
            y^2 >= r1^2 - x^2 -> y = celi(sqrt(r1^2 - x^2)) 올림해야함
            y^2 <= sqrt(r2^2 - x^2) 알아서 내림처리
            
            이걸 모든 점에 대해서 하면 100만 * 100만이라 시간초과
            x든 y든 기준을 잡고 거기서 한번에 계산하면 시간복잡도 100만으로 줄일수있음
            음수 양수인데 그냥 한 분면에 대해서만하고 분면의 경계값만 따로 카운팅?
        */
        /*  0 따로 카운팅, r2미만으로하고 r2도 나중에 카운팅? x== r2일땐 y =0 케이스인건데
            x케이스에서 y케이스가 빠진느낌이라 이상하게 느껴지네
            따로하려니까 더 꼬이나?
        */ 
        long count = 0;
        for (int x = 1; x <= r2; x++) {
            double r1Pow = (long) r1 * r1;
            double r2Pow = (long) r2 * r2;
            double xPow = (long) x * x;
            int yLower = Math.max(1, (int) Math.ceil(Math.sqrt(r1Pow - xPow))); 
            int yUpper = (int) Math.sqrt(r2Pow - xPow);
            count += yUpper - yLower + 1;
        }
       
        count += r2 - r1 + 1;
  
    
        return 4 * count;
    }
}