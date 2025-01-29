import java.io.*;
import java.util.*;

public class Main {

    private static int[][] m;   // 입력 행렬
    private static int[][] d;   // DP 테이블 (바텀업)
    private static int n;
    private static int count1 = 0;  // ✅ 코드1 실행 횟수 (재귀 호출)
    private static int count2 = 0;  // ✅ 코드2 실행 횟수 (DP 연산)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ✅ 입력 받기
        n = Integer.parseInt(br.readLine());
        m = new int[n + 1][n + 1];  // 1-based index 사용
        d = new int[n + 1][n + 1];  // DP 테이블 (바텀업 방식)

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ✅ 재귀 호출 방식 실행 (탑다운 방식)
        matrixPath(m, n);

        // ✅ 바텀업 DP 방식 실행
        matrixPathDP(m, n);

        // ✅ 코드1(재귀 호출 횟수)과 코드2(DP 연산 횟수) 출력
        bw.write(count1 + " " + count2);
        bw.flush();
        bw.close();
    }

    // ✅ 재귀 방식 (탑다운) - **메모이제이션 없이 완전 탐색**
    private static int matrixPath(int[][] m, int n) {
        return matrixPathRec(m, n, n);
    }

    private static int matrixPathRec(int[][] m, int i, int j) {
          // ✅ 코드1 실행 횟수 증가 (모든 재귀 호출에서 증가)

        if (i == 0 || j == 0) {  // ✅ 경계를 벗어나면 0 반환
            count1++;
            return 0;
        }
        
        return m[i][j] + Math.max(matrixPathRec(m, i - 1, j), matrixPathRec(m, i, j - 1));
    }

    // ✅ 바텀업 방식 (DP)
    private static void matrixPathDP(int[][] m, int n) {
        // ✅ 초기화: 첫 번째 열과 첫 번째 행을 0으로 설정
        for (int i = 0; i <= n; i++) {
            d[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            d[0][j] = 0;
        }

        // ✅ 점화식 적용 (코드2)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count2++;  // ✅ 코드2 실행 횟수 증가
                d[i][j] = m[i][j] + Math.max(d[i - 1][j], d[i][j - 1]);
            }
        }
    }
}



