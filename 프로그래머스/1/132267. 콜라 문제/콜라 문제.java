class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int now = n;
        
        while (now >= a) {
            answer += (now / a) * b;
            now = (now / a) * b + (now % a);
            
        }
        return answer;
    }
}