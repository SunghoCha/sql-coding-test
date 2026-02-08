class Solution {
    public boolean solution(int x) {
        boolean answer = true;
    
        int sum = 0;
        int target = x;
        while (target > 0) {
            sum += (target % 10);
            target /= 10;
        }
        
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}