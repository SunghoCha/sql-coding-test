import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static long tryNum = 0;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        tryNum = Long.parseLong(st.nextToken());

        int[] input = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int from = 0;
        int to = input.length - 1;
        mergeSort(input, from, to);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] input, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSort(input, from, middle);
            mergeSort(input, middle + 1, to);
            merge(input, from, middle, to);
        }
    }

    private static void merge(int[] input, int from, int middle, int to) {
        
        int[] tmp = new int[to - from + 1];
        int i = from;
        int j = middle + 1;
        int t = 0;
        while (i <= middle && j <= to) {
            if (input[i] <= input[j]) {
                tmp[t++] = input[i++];
            } else {
                tmp[t++] = input[j++];
            }
            count++;
            if (count == tryNum) {
                result = tmp[t - 1];
                return;
            }
        }
        while (i <= middle) {
            tmp[t++] = input[i++];
            count++;
            if (count == tryNum) {
                result = tmp[t - 1];
                return;
            }
        }
        while (j <= to) {
            tmp[t++] = input[j++];
            count++;
            if (count == tryNum) {
                result = tmp[t - 1];
                return;
            }
        }

        for (int k = 0; k < tmp.length; k++) {
            input[from + k] = tmp[k];
        }
    }
}