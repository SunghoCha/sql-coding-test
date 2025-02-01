


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;
    private static long[][] dp;
    private static int[][] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[size][size];
        dp[0][0] = input[0][0];
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = input[i][j] + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = input[i][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(input[i][j] + dp[i - 1][j - 1], input[i][j] + dp[i - 1][j]);
                }
            }
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (dp[size - 1][i] > max) {
                max = dp[size - 1][i];
            }
        }




        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }


}