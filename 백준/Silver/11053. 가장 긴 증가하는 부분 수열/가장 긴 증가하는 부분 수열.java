


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

        int num = Integer.parseInt(br.readLine());
        dp = new long[num];
        input = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }




}