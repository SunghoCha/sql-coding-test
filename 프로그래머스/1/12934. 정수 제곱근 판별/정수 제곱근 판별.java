class Solution {
    public long solution(long n) {
        long answer = 0;
        double result = Math.sqrt(n);
        
        if (result == (long) result) {
            long x = (long) result;
            answer = (x + 1) * (x + 1);
        } else {
            answer = -1;
        }
        return answer;
    }
}