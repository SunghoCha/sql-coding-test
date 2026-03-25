class Solution {
    public String solution(int n) {
        /*
            변형된 3진법인가?
            124 124 반복?
            앞자리 -1한다음에 3으로 나눈게 앞자리?
        */
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int num = n % 3;
            if (num == 0) {
                num = 4;
            }
            sb.append(num);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString();

    }
}