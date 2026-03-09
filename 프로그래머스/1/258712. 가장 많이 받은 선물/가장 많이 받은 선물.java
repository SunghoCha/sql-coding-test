import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        /*
            선물횟수 우선순위, 횟수 같으면 선물지수가 큰 사람이 받음
            선물지수: 준 선물 - 받은 선물 개수
            선물횟수, 지수가 같으면 선물주고받지않음
            선물을 가장 많이 받을 친구가 받을 선물의 수는?
            
            맵의 중첩자료구조 형태일거같은데? 여기서 키,벨류 순서 중요
            key가 선물 준 사람의 목록을 value?
            key한테 선물 준 사람의 목록을 value?
            
            데이터로 가공하는 흐름을 보면 무엇이 적절한지 알 수 있을듯
            잘못 설계하면 한 번에 할거 두,세번 일함
            
            주요상태는 선물횟수, 선물지수
            선물횟수: 두 사람 사이에 준 횟수
            선물지수: 자신이 친구들에게 준 선물의 수, 친구들에게 받은 선물의 수
            맵-리스트 or 맵-맵?
            맵-리스트일경우 (내가 준 리스트 or 내가 받은 리스트)
            -> 두 사람 사이에 준 횟수 구하기 : list에서 개수카운팅? 좀 애매한데?
            그냥 맵-맵으로 하게되면?
            a가 b에게 준 개수 바로 얻음 b가 a에게 준개수도 바로 얻음
            a가 모든 친구들한테 준 횟수도 쉽게얻음
            
        */
        Map<String, Map<String, Integer>> countMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        for (String gift : gifts) {
            String[] strs = gift.split(" ");
            String from = strs[0];
            String to = strs[1];
            Map<String, Integer> innerMap = 
                countMap.computeIfAbsent(from, k -> new HashMap<>());            
            innerMap.put(to, innerMap.getOrDefault(to, 0) + 1);
            totalMap.put(from, totalMap.getOrDefault(from, 0) + 1);
            totalMap.put(to, totalMap.getOrDefault(to, 0) - 1);
        }
        /*
            이 자료구조 기반으로 구하려고하는건 무엇?
            "다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수"를 구하기 위해선
            모든 조합에 대해서 선물횟수로 구하고 타이일경우 선물지수로 카운팅해줘야함
            이걸 위한 자료구조가 또 있어야하나? 어디에 캐싱해서 해야하나?
            아니면 지금 이중자료구조 하나로 계산가능?
            선물횟수로 우선 맵핑
        */
        int length = friends.length;
        int max = 0;
        for (int i = 0; i < length; i++) { // 조합이 아니고 순열. 자기자신과의 비교만 스킵
            String from = friends[i];
            int fromCount = 0;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                String to = friends[j];
                // 이제 카운팅맵으로 서로 비교. 맵 자체가 없을수도 있음
                int fromTo = countMap.containsKey(from) 
                    ? countMap.get(from).getOrDefault(to, 0) : 0;
                int toFrom = countMap.containsKey(to) 
                    ? countMap.get(to).getOrDefault(from, 0) : 0; 
                
                if (fromTo > toFrom) {
                    fromCount++;    
                } else if (fromTo == toFrom) {
                    // 선물지수 구해야함
                    int totalFromTo = totalMap.getOrDefault(from, 0);
                    int totalToFrom = totalMap.getOrDefault(to, 0);
                    if (totalFromTo > totalToFrom) {
                        fromCount++;
                    }
                }
               
            }
            if (fromCount > max) {
                max = fromCount;
            }
        }
        
        return max;
    }
}