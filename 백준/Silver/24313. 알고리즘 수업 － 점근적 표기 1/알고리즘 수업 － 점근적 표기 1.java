import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // O(n) 정의 확인
        boolean isBigO = true;

        if (a1 > c) {
            // a1 > c인 경우, 어떤 n에서도 조건을 만족하지 않음
            isBigO = false;
        } else {
            // a1 <= c인 경우, n >= n0에서 조건을 확인
            for (int n = n0; n <= 100; n++) { // n0에서 100까지 확인 (문제 조건에 따라)
                if (a1 * n + a0 > c * n) {
                    isBigO = false;
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(isBigO ? 1 : 0);
    }
}