


import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] input = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[j] = Long.parseLong(st.nextToken());
            }
            long[][] dp = new long[n][n];
            long[] prefixSum = new long[n + 1];
            for (int k = 0; k < n; k++) {
                dp[k][k] = 0; // 한 파일의 합치기 비용은 0
                prefixSum[k + 1] = prefixSum[k] + input[k]; // prefixSum[0] = 0; prefixSum[k + 1] : 처음부터 k번째까지의 합
            }
            long result = dpCalculate(dp, input, prefixSum);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    /*
        dp는 보다 작은 구간들의 합으로 이루어짐
        작은 구간들은 이미 완성되어 있어야 함
        작은 구간 -> 0-base-index 기준: 구간 길이 0부터 최대길이(n-1)까지 루프돌면서 계산. 초기값 구간길이0 케이스는 미리 채우고 시작
        2차원 dp배열의 상삼각형 구간을 대각선 방향으로 작은 길이부터 채워나감.
        최대길이에 대한 dp[0][n - 1]은 그동안 채워넣은 dp배열의 값들에 의해서 계산됨
     */


    public static long dpCalculate(long[][] dp, long[] input, long[] prefixSum) {
        int n = input.length;
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long cost = (dp[i][k] + dp[k + 1][j]) + prefixSum[j + 1] - prefixSum[i];
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}