class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;           
        }
        String[] split = sb.reverse().toString().split("0");
        for (String str : split) {
            if (str.equals("")) {
                continue;
            }
            long num = Long.parseLong(str);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 소수 구한ㄴ 무슨 체?
    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
}