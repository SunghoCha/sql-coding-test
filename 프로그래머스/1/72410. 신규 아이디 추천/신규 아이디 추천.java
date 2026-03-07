class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String id = new_id.toLowerCase(); // 소문자로 치환
        StringBuilder sb = new StringBuilder();
        for (char ch : id.toCharArray()) {
            if (Character.isDigit(ch) || Character.isLetter(ch)
               || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        } // 허용안되는 특수 문자 제외
        id = sb.toString();
        sb = new StringBuilder();
        char pre = ' ';
        for (char ch : id.toCharArray()) {
            if (ch == '.' && pre == '.') {
                continue;
            } else if (ch == '.') {
                sb.append(ch);
                pre = ch;
            } else {
                sb.append(ch);
                pre = ch;
            }            
        } // 중복 마침표 제거
        id = sb.toString();
        
        if (id.length() > 0 && id.charAt(0) == '.') {
            id = id.substring(1);
        }
       
        if (id.length() > 0 && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }// 양끝 마침표제거
        
        
        if (id.equals("")) {
            id = "a";
        } else if (id.length() >= 16) {
            id = id.substring(0, 15);
        }
        if (id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        } // 6단계 완료
        
        if (id.length() <= 2) {
            char ch = id.charAt(id.length() - 1);
            sb = new StringBuilder(id);
            while (sb.length() != 3) {
                sb.append(ch);
            }
            return sb.toString();
        }
        
        return id;
    }
}