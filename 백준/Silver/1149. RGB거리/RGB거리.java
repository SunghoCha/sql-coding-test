


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
        dp = new long[size][3];

        input = new int[size][3];
        for (int i = 0 ; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = input[0][0];
        dp[0][1] = input[0][1];
        dp[0][2] = input[0][2];

        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.min(input[i][0] + dp[i - 1][1], input[i][0] + dp[i - 1][2]);
            dp[i][1] = Math.min(input[i][1] + dp[i - 1][0], input[i][1] + dp[i - 1][2]);
            dp[i][2] = Math.min(input[i][2] + dp[i - 1][0], input[i][2] + dp[i - 1][1]);
        }

        long result = Math.min(dp[size - 1][2], Math.min(dp[size - 1][0], dp[size - 1][1]));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }


}