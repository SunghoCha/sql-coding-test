import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        long[] dp = new long[101]; // 1 ≤ N ≤ 100이므로 충분한 크기 선언

        // ✅ 바텀업 방식으로 DP 배열 미리 채우기
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5]; // 점화식 적용
        }

        // ✅ 입력받고 결과 출력
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);
    }
}
