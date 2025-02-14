
import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static long[] input;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        input = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            input[i] = Long.parseLong(st.nextToken());
        }
        // 높이는 long
        // 높이를 조절하면서 적어도 M값 이상을 얻을 수 있는 높이를 찾는 문제
        // 높이에 대한 결과값은 단조 증가하므로 완전탐색을 할 필요가 없음
        // 이진 탐색을 통해 결과값을 찾을 수 있음
        // 0부터 최대나무높이까지의 오름차순 배열에 대해 이진탐색을 수행하고
        // mid값(높이)가 주어졌을 때의 나무길이값을 반환하는 함수의 결과값을 M과 비교하여 탐색 범위를 조절한다

        Arrays.sort(input);

        long maxHeight = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            maxHeight = Math.max(input[i], maxHeight);
        }

        long result = biSearch(input, M, maxHeight);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    }

    public static long biSearch(long[] input, long M, long maxHeight) {
        long left = 0;
        long right = maxHeight;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (M > getTreeLengthSum(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;

    }

    public static long getTreeLengthSum(long height) {
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            long length = ((input[i] - height) >= 0) ? (input[i] - height) : 0;
            sum += length;
        }
        return sum;
    }


}