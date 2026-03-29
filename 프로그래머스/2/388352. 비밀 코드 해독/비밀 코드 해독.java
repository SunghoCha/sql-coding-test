import java.util.*;
class Solution {
    public static int result = 0;
    public int solution(int n, int[][] q, int[] ans) {
        /*
            야구게임같은?
            1 ~ n 중 서로다른 정수 5개가 오름차순. 정수 범위 1 ~ n
            각 시도마다 서로 다른 5개의 정수 입력하면 몇 개가 포함되어있는지 알려줌
            순서없이 포함개수정보만 알려줌
            주어진 쿼리들이 서로다른수지만 이전 정보와 얼마든지 중복가능
            매 쿼리마다 이전 쿼리? 또는 다른 쿼리들의 정보가 필요한건가
            이전쿼리가 포함한 개수 카운팅도 해야하고 지금쿼리와 겹치는 개수도해야하나?
            뭐 어떻게푸는거지
            
            그냥 주어진 숫자중 5개 고르는 모든 수에 대해서 q의 쿼리에 대한 일치체크해서
            ans 다맞으면 result++;?
            30C5 * 10 정도의 시간복잡도?
        */
        boolean[] visited = new boolean[n + 1]; // 1-base로 해야함 0,1부터 n
        Set<Integer> set = new HashSet<>();
        result = 0; // 초기화
        comb(n, 0, 1, visited, set, q, ans);

        return result;
    }
    
    public void comb(int n, int depth, int start, 
                     boolean[] visited, Set<Integer> set, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isCorrect(set, q, ans)) {
                result++;
            }   
            return;
        }
        
        
        for (int i = start; i <= n; i++) { 
            if (!visited[i]) {
                visited[i] = true;
                set.add(i);
                comb(n, depth + 1, i + 1, visited, set, q, ans);
                set.remove(i);
                visited[i] = false;
            }
        }
    }
    
    public boolean isCorrect(Set<Integer> set, int[][] q, int[] ans) {
        
        for (int i = 0; i < q.length; i++) { // 쿼리들에 대해 루프
            int[] cur = q[i];
            int count = 0;
            for (int num : cur) { // 하나의 쿼리와 set의 일치개수 카운트
                if (set.contains(num)) {
                    count++;
                }
            }
            if (count != ans[i]) { // 일치 개수가 맞지않으면 탈락 (하나라도 안맞으면 그걸로 끝)
                return false;
            }
            
        } // 다 통과했으면 전부 개수일치하므로 정답후보임
        return true;
        
    }
}