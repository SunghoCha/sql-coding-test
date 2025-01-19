


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
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(input);

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

    private static void heapSort(int[] input) {
        buildMinHeap(input, N);
        for (int i = N; i >= 2; i--) {
            swap(input, i, 1);
            count++;
            if (count == tryNum) {
                flag = true;
                for (int j = 1; j <= N; j++) {
                    sb.append(input[j]).append(" ");
                }
                return;
            }
            heapify(input, 1, i - 1);
        }
    }

    private static void heapify(int[] input, int k, int n) {
        int left = 2 * k;
        int right = 2 * k + 1;
        int smaller;
        if (right <= n) {
            if (input[right] < input[left]) {
                smaller = right;
            } else {
                smaller = left;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (input[smaller] < input[k]) {
            swap(input, smaller, k);
            count++;
            if (count == tryNum) {
                flag = true;
                for (int j = 1; j <= N; j++) {
                    sb.append(input[j]).append(" ");
                }
                return;
            }
            heapify(input, smaller, n);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void buildMinHeap(int[] input, int n) {
        for (int i = n/2; i >= 1; i--) {
            heapify(input, i, n);
        }
    }

}

