class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        
        for (int i = 1; i <= 9; i++) {
            sum += i;
        }
        for (int j = 0; j < numbers.length; j++) {
            sum -= numbers[j];
        }
        return sum;
    }
}