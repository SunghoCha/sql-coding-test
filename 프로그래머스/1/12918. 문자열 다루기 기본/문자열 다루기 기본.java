class Solution {
    //Character.isDigit(ch)
    public boolean solution(String s) {
        boolean answer = true;
        int length = s.length();
        if (length != 4 && length != 6) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return answer;
    }
}