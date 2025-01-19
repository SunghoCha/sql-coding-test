


import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static int N;
    private static int result = 0;
    private static boolean flag = false;
    private static int[] B;
    private static int[] input;
    private static int idx = -1;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tryNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[N + 1];
        input[0] = 0;
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        heap_sort();

        if (flag) {
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } else {
            bw.write("-1");
            bw.flush();
            bw.close();
        }

    }

    private static void heap_sort() {
        buildMinHeap(input.length);
        for (int i = N; i >= 2; i--) {
            swap(1, i);
            count++;
            if (count == tryNum) {
                flag = true;
                sb.append(input[i]).append(" ").append(input[1]);
                return;
            }
            heapify(1, i - 1);
        }
    }

    private static void heapify(int k, int n) {
        int smaller = 0;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (right <= n) {
            if (input[left] < input[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;

        } else {
            return;
        }
        if (input[smaller] < input[k]) {
            swap(smaller, k);
            count++;
            if (count == tryNum) {
                flag = true;
                sb.append(input[k]).append(" ").append(input[smaller]);
                return;
            }
            heapify(smaller, n);
        }
    }

    private static void swap(int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    private static void buildMinHeap(int length) {
        for (int i = N / 2; i >= 1; i--) {
            heapify(i, N);
        }
    }

}

