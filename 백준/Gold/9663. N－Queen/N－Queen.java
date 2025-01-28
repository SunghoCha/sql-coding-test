


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] board;
    private static StringBuilder sb;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        board = new int[N];

        int row = 0;
        backTrack(row);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    private static void backTrack(int row) {
        if (row == N) {
            count++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isValidPosition(col, row)) {
                board[row] = col;
                backTrack(row + 1);
            }
        }
    }

    private static boolean isValidPosition(int col, int row) {
        for (int preRow = 0; preRow < row; preRow++) {
            if (board[preRow] == col ||
                    Math.abs(board[preRow] - col) == Math.abs(preRow - row)) {
                return false;
            }
        }
        return true;
    }
}
