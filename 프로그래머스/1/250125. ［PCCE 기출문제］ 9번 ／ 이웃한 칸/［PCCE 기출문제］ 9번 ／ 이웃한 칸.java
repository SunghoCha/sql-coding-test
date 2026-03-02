class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
            
        String target = board[h][w];
        for (int i = 0; i < 4; i++) {
            int newH = h + dh[i];
            int newW = w + dw[i];
            if (newH >= 0 && newH < board.length 
                && newW >= 0 && newW <board[0].length) {
                if (target.equals(board[newH][newW])) {
                    answer++;
                }   
            }
        }
                
        return answer;
    }
}