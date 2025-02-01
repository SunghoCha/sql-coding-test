


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;
    private static long[] dp;
    private static int[] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[size];
        dp[0] = input[0];
        if (size >= 2) {
            dp[1] = input[0] + input[1];
        }
        if (size >= 3) {
            dp[2] = Math.max(input[0] + input[2], input[1] + input[2]);
        }
        for (int i = 3; i < size; i++) {
            dp[i] = Math.max(input[i] + input[i - 1] + dp[i - 3], input[i] + dp[i - 2]);
        }


        bw.write(String.valueOf(dp[size - 1]));
        bw.flush();
        bw.close();
    }


}