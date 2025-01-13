import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        String result = solution(N, K, nums);
        bw.write(result);
        bw.flush();
        bw.close();
    }

    public static String solution(int N, int K, int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < N; i++) {
            position.put(nums[i], i);
        }

        int count = 0;
        for (int j = N - 1; j >= 0; j--) {
            if (nums[j] != sortedNums[j]) {
                int minValue = nums[j];
                int maxValue = sortedNums[j];

                // Swap nums[j] with nums[position[maxValue]]
                int temp = nums[j];
                nums[j] = maxValue;
                nums[position.get(maxValue)] = temp;

                // Update positions in the map
                position.put(minValue, position.get(maxValue));
                position.put(maxValue, j);

                count++;
                if (count == K) {
                    return Math.min(minValue, maxValue) + " " + Math.max(minValue, maxValue);
                }
            }
        }

        return "-1";
    }
}