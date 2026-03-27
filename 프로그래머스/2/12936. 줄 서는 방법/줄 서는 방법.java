import java.util.*;
import java.util.stream.*;
class Solution {
    public int count = 0;
    public long[] memo;
    public int[] solution(int n, long k) {
        
        /*
            순열에서 k번째 방법 리턴 사전순 k번째
            그냥 백트래킹하면서 전역변수 두고 k랑 일치하면 해당 list반환?
            k가 long임에 주의
            그냥 순열로 풀면 시간초과
            3명이면 맨 앞에 2,2,2 -> (n-1)이 n개
            k =5 면
            n-1인 2로 나눔. 몫이 2 나머지가 1
            그러면 맨 앞수는 몫 + 1인 것들 중 나머지(1)번째 수
            근데 이게 재귀적으로 자리수하나씩 줄이면서 찾는건가?
            
        */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1); // 인덱스0에서 1,2,3.. 채움
        }
        k = k - 1;
        int[] ans = new int[n];
        memo = new long[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        int idx = 0;
        while (list.size() != 0) {
            int num = (int)(k / factorial(n - 1)); // 인덱스를 의미
            ans[idx++] = list.get(num);
            list.remove(num);
            k %= factorial(n - 1);
            n--;
            
        }
        return ans;
        
    }
    
    /*
        memo[0] = 1
        [1] = 1
        [2] = 2 * [1]
        [n] = n * [n-1]
    */
    public long factorial(int n) {
        if (memo[n] != 0) {
            return memo[n];    
        }
        memo[n] = n * factorial(n - 1);
        return memo[n];
    }
}