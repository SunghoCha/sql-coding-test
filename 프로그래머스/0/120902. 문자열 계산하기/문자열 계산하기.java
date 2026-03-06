class Solution {
    public int solution(String my_string) {
        /*
            숫자 or 공백 or 연산자
            공백은 바로 리턴
            숫자가 한자리수가 아니라서 이걸 찾는 로직 필요. while문으로 숫자찾아서 확정
        
        */
        int result = 1000000;
        char oper = ' ';
        int length = my_string.length();
        for (int i = 0; i < length; i++) {
            if (my_string.charAt(i) == ' ') {
                continue;
            }
            
            if (!Character.isDigit(my_string.charAt(i))) {
                oper = my_string.charAt(i);
            }
            
            if (Character.isDigit(my_string.charAt(i))) {
                int num = 0;
                while (i < length && Character.isDigit(my_string.charAt(i))) {
                    num = (10 * num) + Character.getNumericValue(my_string.charAt(i));
                    i++;
                }
                i--;
                if (result == 1000000) {
                    result = num;
                } else {
                    if (oper == '+') {
                        result += num;
                    } else {
                        result -= num;
                    }
                }
            
            }
            
            
        }
        return result;
    }
}