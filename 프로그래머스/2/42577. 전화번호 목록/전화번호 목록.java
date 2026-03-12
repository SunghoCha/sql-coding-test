import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        /*
            배열 길이가 100만. n^2 불가능
            100만건을 해시셋이 저장하고 각각의 100만건의 최대 20글자인 문자열을
            길이 1, 2, 3.. 자른것이 해시셋에 있으면 즉시 false 다 돌고도 없으면 true
        */
        Set<String> set = new HashSet<>();
        for (String str : phone_book) {
            set.add(str);    
        }
        
        for (String str : set) {
            int length = str.length();
            int pointer = 1; 
            // substring에서 사용할거라서 1부터 length - 1까지. -> 1자리부터 str - 1까지
            while (pointer < length) {
                String prefix = str.substring(0, pointer);
                pointer++;
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}