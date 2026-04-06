import java.util.*;

/**
 * 여행경로
 * 전략: DFS + used 배열 + 도착지 알파벳순 정렬
 * 시간복잡도: O(N! × N) 최악, 실제론 정렬+조기종료로 훨씬 빠름
 */
class Solution {

    private String[][] tickets;
    private boolean[] used;
    private List<String> route;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.used = new boolean[tickets.length];
        this.route = new ArrayList<>();

        // 도착지 기준 알파벳순 정렬 → 처음 완성된 경로 = 최솟값 경로
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        // ICN에서 출발
        route.add("ICN");

        // SEARCHING: DFS 시작
        dfs("ICN", 0);

        return route.toArray(new String[0]);
    }

    /**
     * DFS 탐색
     * @param current 현재 공항
     * @param usedCount 지금까지 사용한 티켓 수
     * @return 모든 티켓을 소진한 경로를 찾으면 true
     */
    private boolean dfs(String current, int usedCount) {
        // COMPLETE: 모든 티켓을 사용했으면 경로 완성
        if (usedCount == tickets.length) {
            return true;
        }

        // SEARCHING: 현재 공항에서 출발 가능한 미사용 티켓 탐색
        for (int i = 0; i < tickets.length; i++) {
            // 이미 사용한 티켓이거나 출발지가 다르면 건너뜀
            if (used[i] || !tickets[i][0].equals(current)) {
                continue;
            }

            // USING: 티켓 사용 → 다음 공항으로 이동
            used[i] = true;
            route.add(tickets[i][1]);

            // 재귀 탐색
            if (dfs(tickets[i][1], usedCount + 1)) {
                // COMPLETE 체인 전파: 정답을 찾았으면 즉시 종료
                // (이 return이 없으면 백트래킹이 정답 경로를 지워버림)
                return true;
            }

            // BACKTRACK: 이 경로로는 모든 티켓 소진 불가 → 되돌리기
            used[i] = false;
            route.remove(route.size() - 1);
        }

        // SEARCHING: 모든 티켓을 시도했지만 경로 없음
        return false;
    }
}
