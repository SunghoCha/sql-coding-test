import java.util.*;
class Solution {
    static int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        /*
            최소 필요 피로도, 소모 피로도
            하루에 한 번씩 탐험할 수 있는 던전
            던전들을 최대한 많이 탐색하려 함
            유저가 탐헐할 수 있는 최대 던전 수
            소모 피로도만 있으면 작은것부터 그리디하게 탐색가능할텐데
            필요피로도가 있으면 달라지나?
            그래도 필요피로도는 입장조건일뿐이고 최소피로도 낮은순 정렬하고 탐험가능한건 하는게 맞을듯?
            
            완탐으로 풀어야할듯 arr이 8이하니까 반복문으로 풀면 힘들고 백트래킹 visited?
            근데 가지치기가 가능한가
        */
       
        boolean[] visited = new boolean[dungeons.length];
        List<Integer> list = new ArrayList<>(); // 던전 인덱스 리스트
        backtrack(k, dungeons, 0, visited, list);
        
        return max;
    }
    /*
        순열 다 채워진 배열 : 던전 방문 순서. 여기서 루프돌아서 방문횟수 계산하고 max 갱신
    */
    public static void backtrack(int k, int[][] dun, int depth,
                                 boolean visited[], List<Integer> list) {
        if (depth == dun.length) {
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                int idx = list.get(i); // 던전인덱스
                int cut = dun[idx][0]; // 최소조건 피로도
                int point = dun[idx][1]; // 소모피로도
                if (k < cut) {
                    continue;
                }
                k -= point;
                ans++;
            }
            max = Math.max(max, ans);
        }   
        for (int i = 0; i < dun.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                backtrack(k, dun, depth + 1, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
            
        }
    }
}