import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] props = {
            {"+", "-", "*"}, {"+", "*", "-"},
            {"-", "+", "*"}, {"-", "*", "+"},
            {"*", "+", "-"}, {"*", "-", "+"}
        };
        List<Long> numsOrigin = new ArrayList<>();
        List<String> opersOrigin = new ArrayList<>();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                long num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = (10 * num) + Character.getNumericValue(chars[i]);
                    i++;
                }
                i--; // for문에서 ++되는걸 미리 보정해야 숫자 바로 다음 문자열 체크가능
                numsOrigin.add(num);
                continue;
            } else { // 연산자
                opersOrigin.add(String.valueOf(chars[i]));
            }           
        }
        // nums, opers 세팅 완료
        
        for (String[] prop : props) {
            List<Long> nums = new ArrayList<>(numsOrigin); 
            List<String> opers = new ArrayList<>(opersOrigin);
            /*
                우선순위인 prop에서 제일 앞에있는 연산자를 opers에서 찾는다.
                opers의 인덱스가 i라면 nums의 인덱스 i, i+1에 대해 연산을 수행한다.
                수행 후 i + 1은 삭제하고 i는 새로운 계산값으로 교체
                oper에서도 연산자 삭제.
                결과적으로 num 한 칸 당겨짐.oper도 한 칸 당겨져서 싱크맞음
            */
            for (String currentOp : prop) {
                while (opers.contains(currentOp)) {
                    // opers에서 해당 연산자 인덱스찾음
                    int i = opers.indexOf(currentOp);
                    
                    // nums에서 숫자 찾아서 연산
                    long a1 = nums.get(i);
                    long b1 = nums.get(i + 1);
                    long num = 0;
                    if (currentOp.equals("+")) {
                        num = a1 + b1;
                    } else if (currentOp.equals("-")) {
                        num = a1 - b1;
                    } else if (currentOp.equals("*")) {
                        num = a1 * b1;
                    }
                    
                    // nums, opers 갱신
                    nums.remove(i + 1);
                    nums.set(i, num);
                    opers.remove(i);
                                     
                }        
            }
            long result = nums.get(0);
            answer = Math.max(answer, Math.abs(result));
        }
        return answer;
    }
}