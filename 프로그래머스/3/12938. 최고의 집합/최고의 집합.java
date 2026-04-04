class Solution {
    public int[] solution(int n, int s) {
        /*
            합이 s를 만족시키는 원소의 개수 n
            s는 최대 1억. 이 합을 만드는 원소의 개수는 최대 1만..
            원소의 곱이 최대이려면 각 원소들이 최대한 비슷한 값이어야할듯?
            s를 n으로 나누고 남은 숫자들을 골고루 나눠줌
            나눠받은 수들은 1씩 클듯
            불가능한 케이스는 어떻게 구별?
            s를 n으로 나눴는데 몫이 0이라면 불가능?
        */
        int num = s / n;
        if (num == 0) {
            return new int[]{-1};
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = num;
        }
        int mod = s % n;
        int idx = n - 1;
        while (mod > 0) {
            ans[idx]++;
            mod--;
            idx--;
        }
        
        
        return ans;
    }
}