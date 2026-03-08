import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        /*
            
            결국엔 카운팅맵에서 k 이상인 것들에 대해 정지처리해야함
            정지된 사람 신고한 사람들한테 메일발송(카운팅)
            신고 - 정지르 기록하기 위한 자료구조 필요 -> 객체? 맵?
            맵으로 하면 한 명이 여러개 신고한걸 다룰수없음
            객체가 필요한듯? 최선인가?
            객체 이퀄스해시코드라도하나..
            Map<String, Set<String>> 이걸 떠올리지못했음.. 
            중첩자료구조를 아예 못떠올려서 조언받음
            결과적으로 신고이력 저장하는 중첩자료구조 맵
            신고카운팅 저장하는 카운팅맵
            정지하고나서 중첩자료구조의 value가 해당 정지자 포함하면 해당 key에 카운트
            이걸 int[]로 전달해야하는데.. 이러면 key값을 인덱스에 매칭시키는 맵이 또 필요한가?
        */
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String str : report) {
            String[] split = str.split(" ");
            String singo = split[0];
            String troll = split[1];
            reportMap.computeIfAbsent(singo, key -> new HashSet<>()).add(troll);
            
            
        } // 신고절차 끝
        for (Set<String> set : reportMap.values()) {
            for (String name : set) {
                countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            }
        }
        
        List<String> list = new ArrayList<>();
        for (String key : countMap.keySet()) {
            if (countMap.get(key) >= k) { // 정지
                list.add(key); // 필요한가? 여기서 바로 reportMap에서 리스트뽑는게? 바로 어떻게 뽑지?                
            }
        } // 정지자 리스트 완성
        // 이제 신고자를 찾아내야하는데 이게 어려운듯
        Map<String, Integer> answerMap = new HashMap<>(); // 여기서 맵을 다시 만드는게맞나?
        for (String key : reportMap.keySet()) {
            Set<String> set = reportMap.get(key);
            for (String name : list) { // set, list로 루프도는게 맞나? 복잡도괜찮나
                if (set.contains(name)) {
                    answerMap.put(key, answerMap.getOrDefault(key, 0) + 1);
                }
            }
        }
        // answerMap을 다시 int[]로 어떻게 만들지?
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            answer[i] = answerMap.getOrDefault(name, 0);
        }
        return answer;
    }
}