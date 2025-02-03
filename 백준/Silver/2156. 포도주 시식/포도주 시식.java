


import java.io.*;


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
        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        /*
            연속 3잔 마실수 없음
            현재 선택된걸 i라고할떄 => input[i] + dp[i - 2]이면 되는데 input[i] + dp[i - 1]을 선택할때 => input[i] + input[i - 1] + dp[i - 3]중 max인듯?
            dp[i] = Math.max(input[i] + dp[i - 2], input[i] + input[i - 1] + dp[i - 3])
         */
        calculate(num);


        bw.write(String.valueOf(dp[num - 1]));
        bw.flush();
        bw.close();
    }

    private static void calculate(int num) {
        if (num == 1) {
            dp[0] = input[0];
            return;
        }
        if (num == 2) {
            dp[1] = input[1] + input[0];
            return;
        }
        dp[0] = input[0];
        dp[1] = input[1] + dp[0];
        dp[2] = Math.max(dp[1], Math.max(input[2] + input[1], input[2] + input[0]));

        for (int i = 3; i < num; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(input[i] + dp[i - 2], input[i] + input[i - 1] + dp[i - 3]));
        }
    }


}