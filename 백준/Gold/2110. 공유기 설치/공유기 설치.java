

import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long maxPosition = Long.MIN_VALUE;
        long minPosition = Long.MAX_VALUE;
        long[] input =new long[N];
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(br.readLine());
            maxPosition = Math.max(input[i], maxPosition);
            minPosition = Math.min(input[i], minPosition);
        }

        Arrays.sort(input); // 그리디 알고리즘 적용 위해 정렬

        long maxDistance = maxPosition - minPosition;
        long result = biSearch(input, C, maxDistance);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    public static long biSearch(long[] input, int C, long maxDistance) {
        long left = 1; // 최소 거리
        long right = maxDistance; // 최대 거리

        while (left <= right) {
            long mid = (left + right) / 2;
            if (countNumber(input, mid) < C) { // 해당 거리(mid) 기준 최대 설치 가능한 공유기 수
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    // 그리디 알고리즘 적용. 로컬 해가 최적의 해를 보장
    // 정렬된 배열에 대해 각각의 요소와 바로 전 요소의 거리가 곧 최소 거리이기 때문
    public static int countNumber(long[] input, long mid) {
        int count = 1; // 첫번째 위치에 무조건 공유기 설치
        int lastInstalled = 0;
        for (int i = 1; i < input.length; i++) {
            // 바로전 "설치된" 요소와의 distance가 mid 이하이면 count++;
            if (input[i] - input [lastInstalled] >= mid) {
                count++;
                lastInstalled = i;
            }
        }
        return count;
    }
}