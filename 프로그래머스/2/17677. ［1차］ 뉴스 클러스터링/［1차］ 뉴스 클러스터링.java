import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        /*
            J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.
            교집합 크기가 0이면 J = 1
            다중집합? 같은 원소를 허용함
            교집합에선 원소개수 작은거기준, 합집합에선 원소개수 많은거기준
            카운팅맵 만들고 
            교집합에선 min개수만큼 포함시킴
            합집합에선 max개수만큼 포함시킴
            
            문자열에 대해서 2글자씩 끊어서 적용. 영문자만 유효. 아닐경우 글자쌍 자체를버림
            대소문자 구분x. 
        */
        List<String> str1Parse = parse(str1.toUpperCase());
        List<String> str2Parse = parse(str2.toUpperCase());
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str1Parse.size(); i++) {
            String str = str1Parse.get(i);
            map1.put(str, map1.getOrDefault(str, 0) + 1);
            set.add(str);
        }
        for (int i = 0; i < str2Parse.size(); i++) {
            String str = str2Parse.get(i);
            map2.put(str, map2.getOrDefault(str, 0) + 1);
            set.add(str);
        }
        int and = 0;
        int or = 0;
        for (String key : set) {
            and += Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            or += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }
        return or == 0 ? 65536 : (and * 65536/ or);
    }
    
    public List<String> parse(String str) {
        int length = str.length();
        List<String> strParse = new ArrayList<>();
        for (int i = 0; i < length - 1; i++) {
            String parse = str.substring(i, i + 2);
            if (Character.isLetter(parse.charAt(0))
                && Character.isLetter(parse.charAt(1))) {
                strParse.add(parse);
            }
        }
        return strParse;
        
    }
}