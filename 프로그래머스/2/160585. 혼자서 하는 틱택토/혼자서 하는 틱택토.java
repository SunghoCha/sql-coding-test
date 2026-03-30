class Solution {
    public char[][] board;
    public int xCount = 0;
    public int oCount = 0;
    public int solution(String[] boardStr) {
        /*
            O,X 번갈아 적고 가로 세로 대각선으로 3개 완성하면 승리
            2가지 실수
             - O를 표시할 차례인데 X OR X를 표시할 차례인데 O를 표기하는 실수
             - 승리조건 완성 후에도 계속 진행하는 실수
            주어진 board가 실수가 발생한 케이스라면 0, 정상이라면 1 반환
            
            그냥 총 개수 같은지 판단하면 순서실수 막을수있지않나?
            그리고 o ,x 둘 다 개수가3개면 실패
            x의 개수는 o보다 많을수없다
            아직 시작도안해서 아무것도 없는 케이스
            
            둘 다 승리
            o승리인데 x도 3개
            x승리인데 o가 4개
            그냥 x가 o보다 많은 케이스
            개수차이가 2개이상
        */
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            char[] chars = boardStr[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                board[i][j] = chars[j];
            }
        }
        
        xCount = getCount('X');
        oCount = getCount('O');

        if (isWin('O')) {
            if (isWin('X')) {
                System.out.println(11);
                return 0;       
            } else if (xCount == oCount) {
                return 0;
            }
        } 

        if (isWin('X')) {
            if (oCount > xCount) {
                return 0;
            }
        }

        if (xCount > oCount) {
            return 0;
        }

        if (oCount > xCount + 1) {
            return 0;
        }

        return 1;
    }
    
    public boolean isWin(char ch) {
        boolean isWin = true;    
        
        // 가로 체크
        for (int i = 0; i < 3; i++) {
            isWin = true;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != ch) {
                    isWin = false;
                    break;
                }   
            }
            if (isWin) {
                return true;
            }
        }
        
        // 세로 체크
        for (int j = 0; j < 3; j++) {
            isWin = true;
            for (int i = 0; i < 3; i++) {
                if (board[i][j] != ch) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return true;
            }
        }
        // 
        for (int i = 0; i < 3; i++) {
            isWin = true;           
            if (board[i][i] != ch) {
                isWin = false;
                break;
            }        
        }
        if (isWin) {
            return true;
        }
        
        for (int i = 0; i < 3; i++) {
            isWin = true;

            if (board[i][2 - i] != ch) {
                isWin = false;
                break;
            }
           
        }
        if (isWin) {
            return true;
        }
        
        return false;
    }
    

    
    public int getCount(char ch) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ch) {
                    count++;
                }
            }
        }
        return count;
    }
    
    
    
    
}