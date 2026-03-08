class Solution {
    
    static int boardX = 0;
    static int boardY = 0;
    
    public int[] solution(String[] park, String[] routes) {

        
        int[][] board = new int[park.length][park[0].length()];
        int curX = 0;
        int curY = 0;
        boardX = park.length;
        boardY = park[0].length();
        for (int i = 0; i < park.length; i++) {
            String str = park[i];
            char[] chars = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                char ch = chars[j];
                if (ch == 'S') { // 0은 디폴트이므로 굳이 설정안해도됨
                    curX = i;
                    curY = j;
                }
                if (ch == 'X') {
                    board[i][j] = 1; // 장애물
                }
            }
        } // board 세팅 완료
        
        for (int i = 0; i < routes.length; i++) {
            String[] str = routes[i].split(" ");
            String direction = str[0];
            int distance = Integer.parseInt(str[1]);
            int posX = curX;
            int posY = curY;
            boolean isOk = true;
            if (direction.equals("E")) { // y 증가
                for (int j = 0; j < distance; j++) {
                    posY++;
                    if (!isValid(posX, posY, board)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    curX = posX;
                    curY = posY; 
                }
            } else if (direction.equals("W")) { // y축이동
                for (int j = 0; j < distance; j++) {
                    posY--;
                    if (!isValid(posX, posY, board)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    curX = posX;
                    curY = posY; 
                }          
            } else if (direction.equals("S")) {
                for (int j = 0; j < distance; j++) {
                    posX++;
                    if (!isValid(posX, posY, board)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    curX = posX;
                    curY = posY; 
                }
            } else if (direction.equals("N")) {
                for (int j = 0; j < distance; j++) {
                    posX--;
                    if (!isValid(posX, posY, board)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    curX = posX;
                    curY = posY; 
                } 
            }

        }
        int[] answer = {curX, curY};
        return answer;
    }
    
    public boolean isValid(int curX, int curY, int[][] board) {
        
        return curX >= 0 
            && curX < boardX
            && curY >= 0
            && curY < boardY
            && board[curX][curY] != 1;
             // boardX,Y는 length라서 인덱스 + 1값
    }
}