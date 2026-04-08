class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        /*
            board 크기는 1000 * 1000 ~ 100만
            스킬은 25만
            완탐으로하면 100만 * 25만. 불가능
            문제를 대충 보면 누적합같은데..
            문제는 정적이지않고 계속해서 값이 변경된다는것.
            해당 영역의 값들을 업데이트한다는것자체가 완탐을 의미하고 시간초과?
        */
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];
        /*
          type r1 c1 r2 c2 degree  
          r1, c1 / r1, c2 + 1 / r2 + 1, c1 / r2 + 1, c2 + 1
        */   
        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = 0;
            if (s[0] == 1) { // 공격
                degree = -s[5];
            } else { // 힐
                degree = s[5];    
            }
            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }    
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}