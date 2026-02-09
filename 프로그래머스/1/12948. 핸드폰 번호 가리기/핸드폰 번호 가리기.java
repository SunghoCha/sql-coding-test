class Solution {
    public String solution(String number) {
        String answer = "";
        int length = number.length();
        answer = number.substring(length - 4);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - 4; i++) {
            sb.append('*');
        }
        sb.append(answer);
        return sb.toString();
    }
}