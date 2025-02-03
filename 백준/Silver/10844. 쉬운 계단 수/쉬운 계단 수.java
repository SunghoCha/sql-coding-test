


import java.io.*;


public class Main {

    private static StringBuilder sb;
    private static long[][] dp;
    private static long NUMBER = 1000000000L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        dp = new long[num][10];
        dp[0][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < num; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % NUMBER;
                }
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % NUMBER;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % NUMBER;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[num - 1][i];
        }


        bw.write(String.valueOf(sum % NUMBER));
        bw.flush();
        bw.close();
    }


}