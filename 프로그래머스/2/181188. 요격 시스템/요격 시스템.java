import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            return a[1] - b[1];
        });
        int count = 0;
        int n = targets.length;
        int last = 0;
        /*
            포함된 케이스일떄의 업데이트는?
            포함했다고 아무것도안함? end는 멀리갔을텐데?
            end는 무조건 갱신?
            근데 last가 요격위치인데 이걸 그냥 갱신한다고?
            
            요격위치는 새로 미사일쏠때만 카운팅과 함께 갱신
            그러면 기존 요격으로 커버되면서 end는 더 멀리간건?
            그냥 무시해도 상관없나?
        */
        for (int i = 0; i < n; i++) {
            int[] target = targets[i];
            int start = target[0];
            int end = target[1];
            
            if (start >= last) { // 포함안됨
                count++;    
                last = end;                
            }  
                                  
        }
            
    
        return count;
    }
}