class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1 ; i <= number; i++) { // 1-base
            int attack = getNumber(i);
            if (attack > limit) {
                attack = power;
            }
            answer += attack;
            
        }
        return answer;
    }
    
    public static int getNumber(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }    
        }
        return count;
    }
}