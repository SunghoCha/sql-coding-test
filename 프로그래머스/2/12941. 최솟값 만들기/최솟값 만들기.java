import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
       
        Arrays.sort(B);
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < B.length; i++) {
            ans += A[A.length - 1 - i] * B[i];
        }
        return ans;
    }
}