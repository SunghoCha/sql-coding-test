
import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static int tryNum;
    private static int count = 0;
    private static boolean flag = false;
    private static int[] input;
    private static int[] B;
    private static int idx = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        compareArray();
        select(input, 0, size - 1, target);

        print(0);
    }

    private static int select(int[] input, int from, int to, int target) throws IOException {
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

    private static int partition(int[] input, int from, int to) throws IOException {
        int pivot = input[to];
        int i = from - 1;

        for (int j = from; j < to; j++) {
            if (input[j] <= pivot) {
                i++;
                swap(input, i, j);
                compareArray();
            }
        }
        if (i + 1 != to) {
            swap(input, i + 1, to);
            compareArray();
        }
        return i + 1;
    }

    private static void compareArray() throws IOException {
        if (idx < 0) {
            idx = 0;
        }
        for (int i = idx; i < input.length; i++) {
            if (input[i] != B[i]) {
                idx = i - 1;
                return ;
            }
        }
        print(1);
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private static void print(int n) throws IOException {
        System.out.println(n);
        System.exit(0);
    }
}