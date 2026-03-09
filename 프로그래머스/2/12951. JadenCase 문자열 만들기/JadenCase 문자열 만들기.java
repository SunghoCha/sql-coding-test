class Solution {
    public String solution(String s) {
        String answer = "";

        /*
            공백이 여러개일 수 있음
        */
        char[] chars = s.toCharArray();
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                isFirst = true;
                sb.append(ch);
                continue;
            }
            if (isFirst) {
                isFirst = false;
                sb.append(Character.toUpperCase(ch));
                continue;
            }
            sb.append(Character.toLowerCase(ch));
        }
        
        
        return sb.toString();
    }
}