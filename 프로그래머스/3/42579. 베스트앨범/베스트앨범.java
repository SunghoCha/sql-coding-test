import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /*
            두개씩 수록
            장르우선, 많이재생, 2개씩만
            같은장르내 많이재생 타이면 고유번호 낮은 순
            MAP?
            키는 장르 벨류는? 자료구조로?
            총재생횟수, 리스트에 고유번호와 재생횟수? 이러면 MAP 안에 리스트 안에 객체 구조인데...
            고유번호 인덱스만으로 재생횟수 바로접근가능한데 굳이..
            만약 키와 총재생횟수만 담는다고치자.
            근데 장르별 리스트가 필요하긴할듯? 장르종류 100개 미만. 음악은 1만개
            * 장르에 속한 곡1개라면 1개만선택, 모든 장르 재생횟수 타이는 없음
            
            한번 루프돌면서 장르,총횟수 맵만들면서 동시에 장르별 리스트도?
            아니면 그냥 합쳐서? 일단 따로해보자
            근데 장르별 맵관리는 어떻게? 이것도 맵-리스트 이중구조로 해야함
            결국 맵 2개?
            
            고유번호(~인덱스)만 있으면 장르와 재생횟수 알아낼수있음
            카운팅맵에는 장르별 횟수 다 담아서 장르우선순위 정함
            장르내 우선순위를 정해야하는데.. 
            장르별 고유번호만 따로 모아놓고 정렬기준인 play를 참조해서 이를 기반으로 정렬
            
        */
        // genres plays
        int n = plays.length;
        // 장르카운팅맵 만들기
        Map<String, Integer> countMap = new HashMap<>();
        // 재생횟수맵. 키는 장르, list의 인덱스는 고유번호. 값은 재생횟수
        Map<String, List<Integer>> playMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String gen = genres[i];
            int score = plays[i];
            countMap.put(gen, countMap.getOrDefault(gen, 0) + score);
            playMap.computeIfAbsent(gen, k -> new ArrayList<>()).add(i);        
        }
        
        // 우선 장르 선정
        List<String> keyList = new ArrayList<>(countMap.keySet());
        keyList.sort((a, b) -> countMap.get(b) - countMap.get(a));
        
        // 장르별 우선곡 선정
        List<Integer> result = new ArrayList<>();
        for (String gen : keyList) {
            playMap.get(gen).sort((a, b) -> {
                if (plays[a] == plays[b]) {
                    return a - b; 
                }
                return plays[b] - plays[a];
            });
            List<Integer> songs = playMap.get(gen);
            int limit = Math.min(songs.size() , 2);
            for (int i = 0; i < limit; i++) {
                result.add(songs.get(i));    
            }
            
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}