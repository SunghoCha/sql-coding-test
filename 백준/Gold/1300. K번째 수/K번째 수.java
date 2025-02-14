

import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long K = Long.parseLong(br.readLine());

        // 배열에 저장된 값들은 정해져 있으니 굳이 2차원 배열을 만들어 놓을 필요는 없음
        // 1 ~ N * N에 대해서 이진탐색을 수행한다. mid선택된 그 값으로 f(mid) 와 k값을 비교해서 탐색 범위 좁힘
        // 이진탐색으로 해당 값이 몇번쨰 수인지 구하고 k와 비교해서 탐색 진행. k와 일치할때 값 반환

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
            if (counting(N, mid) >= K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static long counting(long N, long mid) {
        long sum = 0;
        for (int i = 1; i <= N; i ++) {
            sum += Math.min(N, mid / i);
        }
        return sum;
    }
}