import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        /*
            중복없음
            skill을 set에 담은다음에 contain로 하면 포함여부만 가능, 순서가없음..
            contains면 스택/큐에 담아서 체크하면? 배열은 안되나?
            skill.toCharArray()로 해놓고 포인터로 맞는지체크. 중간에 안맞으면 break
            스킬트리는 20개 이하. 각 원소는 26이하니까 해봤자 몇 개 안됨
        */
        
        char[] skills = skill.toCharArray();
        Set<Character> skillSet = new HashSet<>();
        for (char ch : skills) {
            skillSet.add(ch);
        }
        for (String str : skill_trees) {
            
            if (isValid(str, skillSet, skills)) {
                System.out.println(str);
                answer++;
            }
        }
        return answer;
    }
    
    boolean isValid(String str, Set<Character> set, char[] skills) {
        int pointer = 0;
        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                if (ch == skills[pointer]) {
                    pointer++;
                } else {
                    return false;
                }
            }                
        }
        return true;
        
    }
}