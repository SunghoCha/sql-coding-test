class Solution {
    public int solution(int num) {
        int answer = 0;
        long result = (long) num;
        if (num == 1) {
            return 0;
        }
        while (result != 1 && answer < 500) {
            if (result % 2 == 0) {
                result /= 2;
                answer++;
            } else {
                result = result * 3 + 1;
                answer++;
            }
        }
        if (answer >= 500) {
            return -1;
        }
        return answer;
    }
}