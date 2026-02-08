class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     int num = (int) (c - '0');
        //     answer[s.length() - 1 - i] = num;
        // }
        int i = 0;
        while (n > 0) {
            answer[i] = (int) (n % 10);
            n /= 10;
            i++;
        }
        
        return answer;
    }
}