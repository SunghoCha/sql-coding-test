import java.util.*;
class Solution {
    public int solution(String dartResult) {
        /*
            숫자 10나올수있음
            버퍼개념으로 앞에 숫자 저장(그냥 변수로 가능. 바로 앞만 필요)
            숫자 레터 특수문자. 특수문자는 없을수도있음
        */
        
        
        char[] chars = dartResult.toCharArray();
        int[] scores = new int[3];
        int sIdx = 0;
        int i = 0;
        while (i < chars.length) {
            int num = chars[i] - '0';
            i++;
            if (Character.isDigit(chars[i])) {
                num = (10 * num) + Character.getNumericValue(chars[i]);
                i++;
            }
            
            char bonus = chars[i];
            i++;
            if (bonus == 'D') {
                num = (int) Math.pow(num, 2);
            } else if (bonus == 'T') {
                num = (int) Math.pow(num, 3);
            }
            
            scores[sIdx] = num;
            if (i < chars.length && (chars[i] == '*'|| chars[i] == '#')) {
                if (chars[i] == '#') {
                    scores[sIdx] = num * (-1);                    
                } else {
                    if (sIdx != 0) {
                        scores[sIdx - 1] = scores[sIdx - 1] * 2;                        
                    } 
                    scores[sIdx] = num = num * 2;                    
                    
                }
                i++;
            }
            sIdx++;
     
        }
        int ans = 0;
        for (int j = 0; j < 3; j++) {
            ans += scores[j];
        }
        
            
        return ans;    
    }
}