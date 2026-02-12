class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long moneySum = 0L;
        for (int i = 1; i <= count; i++) {
            moneySum += price * i;
        }
        if (money >= moneySum) {
            return 0;
        } else {
            return moneySum - money;
        }
       
    }
}