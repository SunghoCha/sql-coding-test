


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static int tryNum;
    private static int count = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        tryNum = Integer.parseInt(st.nextToken());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        select(input, 0, size - 1, target);

        if (flag) {
            bw.write(sb.toString().trim());
            bw.flush();
            bw.close();
        } else {
            bw.write("-1");
            bw.flush();
            bw.close();
        }
    }

    private static int select(int[] input, int from, int to, int target) {
        if (from == to) {
            return input[from];
        }
        int pivotIdx = partition(input, from, to);
        int k = pivotIdx - from + 1; // k번째 작은 원소. pivotIdx에 해당하는 원소는 k번재 작은 원소

        if (target < k) {
            return select(input, from, pivotIdx - 1, target);
        } else if (target == k) {
            return input[pivotIdx];
        } else {
            return select(input, pivotIdx + 1, to, target - k);
        }
    }

    private static int partition(int[] input, int from, int to) {
        int pivot = input[to];
        int i = from - 1;

        for (int j = from; j < to; j++) {
            if (input[j] <= pivot) {
                int tmp = input[j];
                input[j] = input[++i];
                input[i] = tmp;

                count++;
                if (count == tryNum) {
                    flag = true;
                    sb.append(Math.min(input[i], input[j])).append(" ").append((Math.max(input[i], input[j])));
                }
            }
        }
        if (i + 1 != to) {
            int tmp = input[i + 1];
            input[i + 1] = input[to];
            input[to] = tmp;

            count++;
            if (count == tryNum) {
                flag = true;
                sb.append(Math.min(input[i + 1], input[to])).append(" ").append((Math.max(input[i + 1], input[to])));
            }
        }
        return i + 1;
    }

    private static void swap(int[] input, int ro, int hi) {
        int tmp = input[ro];
        input[ro] = input[hi];
        input[hi] = tmp;
    }
}

