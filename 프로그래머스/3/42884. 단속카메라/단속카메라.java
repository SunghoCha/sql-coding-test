import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        /*
            닫힌구간처리
            그라디로 접근
            그라디로 출발점? 끝나는지점? 어디를 기준으로 할 것인지 생각해보자
            이러면 최대한 늦은 지점에서 체크하는게 나을듯?
            last 지점을 놔두고
        */
        int last = -30001;
        int count = 0;
        Arrays.sort(routes, (a, b) -> {
            return a[1] - b[1];
        });
        for (int i = 0; i < routes.length; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            if (start > last) { // 닫힌구간이라 같을 경우 포함됨
                
                last = end;    
                count++;
            }
        }
        
        return count;
    }
}