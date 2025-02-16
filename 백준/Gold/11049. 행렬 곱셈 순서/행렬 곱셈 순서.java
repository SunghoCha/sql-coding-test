

import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] dims = new int[n + 1];
        long[][] dp = new long[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dims[0] = Integer.parseInt(st.nextToken());
        dims[1] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            dims[i + 1] = Integer.parseInt(st.nextToken());
            dp[i][i] = 0;
        }

        // 작은 길이부터 채워야함 len 반복
        // 시작행렬 i =0 ~ i < n - len 까지 반복
        // 해당 구간을 나누는 i <= k < j 반복
        long result = dpCalculate(dp, dims, n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static long dpCalculate(long[][] dp, int[] dims, int n) {
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] +(long) dims[i] * dims[k + 1] * dims[j + 1];
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
