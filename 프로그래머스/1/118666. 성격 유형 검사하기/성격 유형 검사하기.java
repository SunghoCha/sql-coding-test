import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        /*
            4개의 지표, 각 지표에서 7가지 케이스 선택해서 둘 중 하나의 유형
            2*2*2*2 해서 16가지 경우의 수
            RT : 비동의 동의
            ["AN", "CF", "MJ", "RT", "NA"]  / [5, 3, 2, 7, 5]	
            N1 C1 M2 T3 A1  "같으면 사전순"
        */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String sur = survey[i];
            char first = sur.charAt(0); // A
            char second = sur.charAt(1); // N
            // 점수얻어서 추가
            int choice = choices[i];
            if (choice < 4) {
                map.put(first, map.getOrDefault(first, 0) + 4 - choice);
            } else if (choice > 4) {
                map.put(second, map.getOrDefault(second, 0) + choice - 4);
            }            
        } // map에 8개 타입별로 카운팅됨
        /* 이제 2개씩 짝지어진 타입비교해야하는데.. 
        이건 어떤 자료구조에 미리 담겨있어서 여기서 4번의 루프를 돌면서 map 호출해서 비교?
        같으면 사전순 어떻게 적용?
        */
        String[] pairs = {"RT", "CF", "JM", "AN"};
        StringBuilder sb = new StringBuilder();
        for (String pair : pairs) {
            int a = map.getOrDefault(pair.charAt(0), 0);
            int b = map.getOrDefault(pair.charAt(1), 0);
            if (a == b) {
                sb.append(pair.charAt(0));
            } else if (a > b) {
                sb.append(pair.charAt(0));
            } else {
                sb.append(pair.charAt(1));
            }
            
        }
        return sb.toString();
    }
}