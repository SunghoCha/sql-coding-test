class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int num = 0;
            int idx = i;
            while (idx <= n && num < n) {
                num += idx;
                idx++;
            }
            if (num == n) {
                answer++;
            }
        }
        return answer;
    }
}