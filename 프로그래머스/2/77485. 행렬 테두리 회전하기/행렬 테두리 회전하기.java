class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        /*
            직사각형(정사각형은 안되나?) 모양 범위를 여러번 선택해
            테두리 부분에 있는 숫자들을 시계방향으로 회전
            보드판을 만들어서해야하나? 아니면 없이?
            없이 불가능할거같은데? 
            일단 board만들고 시작
            rotate는 어떻게 구현할건지?
            우선 일차원 배열에 대해 구현해서 원리파악하고 확장?
            꼭지점에 있는 원소들과 그렇지 않은 원소들로 구별?
            그렇지않은 원소들은 가로 세로로 구별?
            주어진 2개의 좌표로 4개의 꼭지점 좌표만들고 ?
            
            리뷰받음
            그냥 임시값하나 저장하고 나머지 시계방향으로 당기는 구현문제?
            한 변씩 리스트로 저장해놓고 저장하려고했는데 그냥 한 칸씩 당기면 되는듯
            
        */
        
        int[] ans = new int[queries.length];
        int idx = 0;
        int[][] board = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = i * columns + j + 1;    
            }
        }
        for (int[] query : queries) {
            int x1 = query[0] - 1; // 0-base 인덱스로 치환
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            ans[idx++] = rotate(x1, y1, x2, y2, board);
        }
        
        return ans;
    }
    
    public int rotate(int x1, int y1, int x2, int y2, int[][] board) {
        // 구현
        int m = board.length;
        int n = board[0].length;
        int tmp = board[x1][y1];
        // 왼쪽 변. 위에서부터 한칸씩 당김. j = y1
        int min = tmp;
        for (int i = x1; i < x2; i++) { // j = y1
            board[i][y1] = board[i + 1][y1]; // x1 ~ x2 - 1까지 값 세팅    
            min = Math.min(min, board[i + 1][y1]);
        }
        // 아래변. 왼쪽에서부터 한칸씩 당김. i = x2
        for (int j = y1; j < y2; j++) {
            board[x2][j] = board[x2][j + 1];
            min = Math.min(min, board[x2][j + 1]);
        }
        // 오른쪽 변. 아래서부터 한칸씩 당김. j = y2
        for (int i = x2; i > x1; i--) {
            board[i][y2] = board[i - 1][y2];
            min = Math.min(min, board[i - 1][y2]);
        }
        // 위쪽변. 오른쪽에서부터 한칸씩 당김. i = x1. board[x1][y1 + 1] 은 따로.
        for (int j = y2; j > y1 + 1; j--) {
            board[x1][j] = board[x1][j - 1];
            min = Math.min(min, board[x1][j - 1]);
        }
        board[x1][y1 + 1] = tmp;
        return min;
    }
}