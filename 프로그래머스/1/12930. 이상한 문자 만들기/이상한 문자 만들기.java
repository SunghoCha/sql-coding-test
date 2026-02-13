class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                idx = 0;
                sb.append(' ');
                continue;
            }    
            if (idx % 2 == 0) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(Character.toLowerCase(ch));
            }
            idx++;   
        }
        return sb.toString();
    }
}