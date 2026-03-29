import java.util.*;

/**
 * 지게차와 크레인
 *
 * 전략: 테두리 확장 + BFS 범람
 * - board를 (n+2)×(m+2)로 확장, 테두리를 '0'으로 채워 가상 외부 공간 구성
 * - 지게차: (0,0)에서 BFS로 '0' 영역을 퍼뜨리며 인접한 target 컨테이너를 제거
 * - 크레인: board 전체 순회하여 target 컨테이너를 모두 제거
 *
 * 시간복잡도: O(requests × n × m) ≈ 100 × 52 × 52 = 270,400
 */
class Solution {

    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        // [초기화] board를 (n+2)×(m+2)로 생성, 테두리는 '0', 원본 데이터는 (1,1)부터 배치
        char[][] board = initBoard(storage, n, m);

        // [요청처리] 각 요청을 순서대로 처리
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 1) {
                // [지게차처리] BFS로 외부 공간에 인접한 target 컨테이너 제거
                forklift(board, n, m, target);
            } else {
                // [크레인처리] 전체 순회하여 target 컨테이너 모두 제거
                crane(board, n, m, target);
            }
        }

        // [결과반환] '0' 아닌 칸의 수를 세어 반환
        return countRemaining(board, n, m);
    }

    /**
     * board 초기화
     * - 크기: (n+2) × (m+2)
     * - 테두리(행 0, n+1 / 열 0, m+1): '0' (가상 외부 공간)
     * - 내부 (1,1) ~ (n,m): storage 원본 데이터
     */
    private char[][] initBoard(String[] storage, int n, int m) {
        char[][] board = new char[n + 2][m + 2];

        // 전체를 '0'으로 초기화 (테두리 포함)
        for (char[] row : board) {
            Arrays.fill(row, '0');
        }

        // 원본 데이터를 (1,1)부터 배치
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                board[r + 1][c + 1] = storage[r].charAt(c);
            }
        }

        return board;
    }

    /**
     * 지게차 처리
     * - (0,0)에서 BFS 시작 → '0' 영역(외부 공간)을 퍼뜨림
     * - 이웃이 '0'이면 외부 공간으로 확장 (큐에 삽입)
     * - 이웃이 target이면 '0'으로 변경 후 큐에 삽입 (연쇄 탐색 허용)
     * - 이웃이 다른 문자면 무시
     */
    private void forklift(char[][] board, int n, int m, char target) {
        // 1단계: BFS로 '0'만 타고 퍼져서 외부 공간 집합 구하기
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];

                if (nr < 0 || nr >= n + 2 || nc < 0 || nc >= m + 2) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                // '0'(빈 칸)만 큐에 넣어 외부 공간 확장 — target이든 다른 문자든 큐에 넣지 않음
                if (board[nr][nc] == '0') {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        // 2단계: 외부 공간(visited)에 인접한 target 컨테이너를 제거
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (board[r][c] != target) {
                    continue;
                }
                // 4방향 중 하나라도 외부 공간이면 접근 가능
                for (int d = 0; d < 4; d++) {
                    int nr = r + DR[d];
                    int nc = c + DC[d];
                    if (visited[nr][nc]) {
                        board[r][c] = '0';
                        break;
                    }
                }
            }
        }
    }

    /**
     * 크레인 처리
     * - board 전체를 순회하여 target 컨테이너를 모두 '0'으로 변경
     * - 외부 연결 여부와 무관하게 전량 제거
     */
    private void crane(char[][] board, int n, int m, char target) {
        // [전체순회] 내부 칸만 순회 (테두리는 이미 '0'이므로 생략 가능하지만 명확성을 위해 범위 지정)
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (board[r][c] == target) {
                    // [전체제거] target 컨테이너 제거
                    board[r][c] = '0';
                }
            }
        }
    }

    /**
     * 남은 컨테이너 수 반환
     * - '0'이 아닌 칸(알파벳 대문자)의 수를 반환
     */
    private int countRemaining(char[][] board, int n, int m) {
        int count = 0;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (board[r][c] != '0') {
                    count++;
                }
            }
        }
        return count;
    }
}
