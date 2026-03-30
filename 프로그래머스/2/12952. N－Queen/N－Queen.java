class Solution {
    public int count = 0;
    
    public int solution(int n) {
        
        int[] queens = new int[n]; // 인덱스가 행, 값이 열
        dfs(0, n, queens);
        
       
        return count;
    }
    /*
      row : 현재 행
      col : 현재 col
    */
    public void dfs(int row, int n, int[] queens) {
        if (row == n) {
            count++;
            return;
        }
        
        for (int col = 0; col < n; col++) { 
            if (isValid(queens, row, col)) {
                queens[row] = col;
                dfs(row + 1, n, queens);
                
            }            
        }
    }
    
    public boolean isValid(int[] queens, int row, int col) {
        for (int qrow = 0; qrow < row; qrow++) {
            int qcol = queens[qrow];
            if (row == qrow) {
                return false;
            }
            if (col == qcol) {
                return false;
            }
            if (Math.abs(qrow - row) == Math.abs(qcol - col)) {
                return false;
            }
        }
        return true;
    }
}