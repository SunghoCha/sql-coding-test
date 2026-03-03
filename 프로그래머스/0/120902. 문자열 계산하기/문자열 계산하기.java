class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] chars = my_string.toCharArray();
        int length = chars.length;
        int pre = 0;
        boolean isPre = true;
        char oper = ' ';
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                continue; // 공백은 스킵
            }
            
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < length && Character.isDigit(chars[i])) {
                    num = (10 * num) + Character.getNumericValue(chars[i]);
                    i++;
                }
                i--; // 위에 for문에서 ++하기때문에 보정
                
                if (isPre) {
                    pre = num;
                    isPre = false;
                    continue;
                }
                // pre가 아닌 숫자면 계산해야함. 연산자도 있는 상태
                int result = 0;
                if (oper == '+') {
                    pre = pre + num;
                } else if (oper == '-') {
                    pre = pre - num;
                }
                          
                
            } else if (!Character.isDigit(ch)) { // 공백은 위에서 걸러짐
                oper = ch;
            }
        }
        
        
        return pre;
    }
}