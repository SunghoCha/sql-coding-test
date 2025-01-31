


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;
    private static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        dp = new long[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = input[0];
        long maxSum = dp[0];
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(dp[i - 1] + input[i], input[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }


        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();

    }


}