import java.util.*;
class Solution {
    public int solution(int n, int number) {
        
        /*
            N과 사칙연산만을 최소로 사용해서 number 만들기. 최소값이 8보다 크면 -1 반환
            예를 들어 N = 5일때.
            5를 이어붙이면 55가 되는?
            가능한 방법
            n이어붙이기, 사칙연산?
            dp[number] : number를 만들떄 사용한 n 개수의 최소값
            사용가능한 방법들의 제한이 없으니까 상태키정보는 아닌건가?
            그래서 그냥 1차원 dp로 가능?
            
            리뷰받음
            dp를 다르게 정의
            dp[k] : k번 사용해서 만들 수 있는 수의 집합?
        */
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 0; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        dp[1].add(n);
        for (int k = 2; k <= 8; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(n);
            }
            int num = Integer.parseInt(sb.toString());
            dp[k].add(num);
            for (int i = 1; i < k; i++) { // 1,k-1 2,k-2,.. k-1,1
                for (int a : dp[i]) {
                    for (int b : dp[k - i]) {
                        dp[k].add(a + b);
                        dp[k].add(a - b);
                        dp[k].add(a * b);
                        if (b != 0) {
                            dp[k].add(a / b);
                        }
                    }
                }
            }
        }
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> set = dp[i];
            if (set.contains(number)) {
                return i;
            }
        }
       
        return -1;
    }
}