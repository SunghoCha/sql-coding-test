

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        long result = biSearch(N, K);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    // K번째에 해당하는 값을 리턴
    public static long biSearch(long N, long K) {
        long left = 1;
        long right = N * N;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (counting(N, mid) >= K) { // 여기서 >= 비교해야 한다!
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // ✅ 올바르게 수정
    }

    public static long counting(long N, long mid) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, mid / i);
        }
        return sum;
    }
}
