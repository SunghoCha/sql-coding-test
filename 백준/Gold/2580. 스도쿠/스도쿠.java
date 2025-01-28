


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] board = new int[9][9];
    private static StringBuilder sb;
    private static List<Point> emptyCells;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        emptyCells = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    emptyCells.add(new Point(i, j));
                }
            }
        }
        /*
           상태값 전달
           emptyCell의 마지막 인덱스
         */
        int index = 0;
        backTrack(index);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static boolean backTrack(int index) {
        /*
            마지막 인덱스 or 마지막 인덱스 초과일떄인지 유의
            index의 업데이트가 로직 처리 전에 되는지 or 로직 처리 후에 되는지
         */
        if (index == emptyCells.size()) {
            return true;
        }
        Point point = emptyCells.get(index);
        int x = point.getX();
        int y = point.getY();

        for (int num = 1; num <= 9; num++) {
            if (isValidNumber(x, y, num)) {
                board[x][y] = num;
                if (backTrack(index + 1)) {
                    return true;
                }
                board[x][y] = 0;
            }
        }

        return false;


    }

    private static boolean isValidNumber(int x, int y, int num) {
        // 가로 세로 확인
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num || board[i][y] == num) {
                return false;
            }
        }

        // 3*3 영역 확인
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startX + i][startY + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
