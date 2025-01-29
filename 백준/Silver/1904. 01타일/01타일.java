


import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        /*
            1, 00의 조합으로 길이가 N인 수를 만들어야함
            1 or 00을 더하면서 길이 count하다가 특정 조건 만족하면 return?
            개수를 15746으로 나눈 나머지를 출력
            * N이 매우 커서 단순 재귀로 구현하면 시간초과.
            백트래킹으로 가능?
            점화식이므로 DP. 점화식인지는 어떻게 파악하지? 경험?
         */
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        int result = dPro(n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int dPro(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = (dPro(n - 1) + dPro(n - 2)) % 15746;

    }

}