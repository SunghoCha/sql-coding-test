class Solution {
    public int solution(String my_string) {
        int answer = 0;
        int length = my_string.length();
        int idx = 0;
        while (idx < length) {
            char ch = my_string.charAt(idx);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (idx < length && Character.isDigit(my_string.charAt(idx))) {
                    num = (num * 10) + Character.getNumericValue(my_string.charAt(idx));
                    idx++;
                } 
                answer += num;
            }
            idx++;
            
        }
        return answer;
    }
}