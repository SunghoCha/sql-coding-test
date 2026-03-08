import java.util.*;
class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        /*  
            callings에 있으면 players에서 그 앞에 있는것과 교환하는 메커니즘
            players의 플레이어이름으로 인덱스를 찾을 수 있어야함
            그걸 위한 map?
        */
        for (int i = 0; i < callings.length; i++) {
            String name = callings[i];
            int idx = map.get(name);
            swap(idx, players);
        }
        return players;
    }
    
    public static void swap(int idx, String[] players) {
        String a = players[idx];
        String b = players[idx - 1];

        players[idx - 1] = a; // swap
        players[idx] = b;
        
        map.put(a, idx - 1); // players 인덱스 정보매핑 갱신
        map.put(b, idx);
    }
}