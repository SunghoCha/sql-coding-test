import java.util.*;
class Solution {
    public long solution(int[] seq) {
        /*
            주어진 수열의 부분수열에 -1로 시작하거나 1로 시작하는 펄스수열 곱해서 합의 최대값구하기
            연속부분수열인거면.. -1또는 1로 시작하는 두 가지 케이스로 아예 분리한다
            연속부분수열이니까 누적합 개념을 활용해볼수있으려나?
            그래서 사실 -1또는 1로 시작하는 펄수수열이 이미 곱해진 수열을 얻었다고 가정하고 수행가능
            그렇다면 연속부분수열의 합의 최대값은 어떻게 구하는가?
            그라디처러 당장 다음값이 음수라고 포기불가능. 바로그다음수가 엄청 큰 양수일수도 있음
            그러면 어떻게? 
            누적합을 구하다가 누적합이 음수가 되는순간 다 버리고 그다음부터 새로 시작?
        */
        // -1부터 시작하는 펄스
        long sum = 0;
        long max1 = Integer.MIN_VALUE;
        for (int i = 0; i < seq.length; i++) {
            int num = 1;
            if (i % 2 == 0) { // -1로 시작
                num = -1;    
            }
            sum += seq[i] * num;
            max1 = Math.max(max1, sum);
            if (sum < 0) { // 부분수열 최소길이 이런건없으니  "=" 부호상관없을듯
                sum = 0;    
            }            
        }
        
        sum = 0;
        long max2 = Integer.MIN_VALUE;
        for (int i = 0; i < seq.length; i++) {
            int num = -1;
            if (i % 2 == 0) { // -1로 시작
                num = 1;    
            }
            sum += seq[i] * num;
            max2 = Math.max(max2, sum);
            if (sum < 0) { // 부분수열 최소길이 이런건없으니  "=" 부호상관없을듯
                sum = 0;    
            }            
        }
        
        return Math.max(max1, max2);
    }
}