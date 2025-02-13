import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 현재 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수

        int[] cables = new int[K]; // 랜선 길이 저장 배열
        long max = 0; // 최대 랜선 길이

        // 입력 받으면서 최댓값 찾기
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            if (cables[i] > max) {
                max = cables[i]; // 가장 긴 랜선 찾기
            }
        }

        // 이진 탐색 (최대 랜선 길이 찾기)
        long left = 1, right = max;
        long result = 0; // 최대 랜선 길이 저장

        while (left <= right) {
            long mid = (left + right) / 2; // 중간값 (자를 길이)
            long count = getCableCount(cables, mid); // mid 길이로 잘랐을 때 만들 수 있는 개수

            if (count >= N) { // N개 이상 만들 수 있으면 길이를 늘려본다.
                result = mid;
                left = mid + 1; // 더 긴 길이 탐색
            } else {
                right = mid - 1; // 짧게 잘라야 하므로 오른쪽을 줄인다.
            }
        }

        System.out.println(result); // 최대 길이 출력
    }

    // 랜선 자르기 함수 (현재 mid 길이로 잘랐을 때 개수 계산)
    private static long getCableCount(int[] cables, long length) {
        long count = 0;
        for (int cable : cables) {
            count += (cable / length); // 현재 길이로 잘라서 몇 개 만들 수 있는지 계산
        }
        return count;
    }
}
