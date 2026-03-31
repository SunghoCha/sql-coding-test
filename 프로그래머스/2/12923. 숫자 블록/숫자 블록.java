class Solution {
    public int[] solution(long begin, long end) {
        
        /*
            기존에 설치된 블록은 빼고 새로운 블록 집어넣음
            길이가 10억이라 완탐 불가능
            결과는 5000개 이하
            5000개 이하라는게 힌트인가? 이 구간에 대해 완탐비슷하게 하는건가?
            블록에 적힌 숫자는 0부터 시작임. 
            n은 n번째 번호부터 까는게 아니고 2 * n, 3 * n, ... 이렇게 설치함
            
            근데보면 짝수는 결국 자기를 2로 나눈 수가 되는거같으데 홀수는 자기를 3으로 나눈 수가 
            되는거같은데 맞나? 아닌듯
            
            결국 자기를 지나는건 자기의 약수들. 약수들 중 가장 큰수로 정해짐
            
            
        */
        // 숫자 1인경우는 특별취급해서 해야하나? 아니면 자기보다작은 약수 구하는 함수에서 처리해놓기
        int range = (int)(end - begin) + 1;
        int[] answer = new int[range];
        for (long i = begin; i <= end; i++) {
            int idx = (int)(i - begin);
            answer[idx] = getNum(i);
        }
        
        return answer;
    }
    
    public int getNum(long num) {
        if (num == 1) {
            return 0;
        }
        int result = 1;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long big = num / i;
                if (big <= 10000000) {
                    return (int) big;
                }
                result = (int) i;
            }
        }
       return result;
    }
}