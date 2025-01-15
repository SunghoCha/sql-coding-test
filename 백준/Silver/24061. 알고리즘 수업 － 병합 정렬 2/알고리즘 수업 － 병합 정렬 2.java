import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static boolean found = false;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        tryNum = Integer.parseInt(st.nextToken());
        int[] input = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(input, 0, size - 1);

        if (found) {
            for (int num : result) {
                bw.write(num + " ");
            }
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }

    private static void mergeSort(int[] input, int from, int to) {
        if (from < to && !found) {
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
                saveState(input, from, tmp, t);
                return;
            }
        }

        while (i <= middle) {
            tmp[t++] = input[i++];
            count++;
            if (count == tryNum) {
                saveState(input, from, tmp, t);
                return;
            }
        }

        while (j <= to) {
            tmp[t++] = input[j++];
            count++;
            if (count == tryNum) {
                saveState(input, from, tmp, t);
                return;
            }
        }

        // 결과 반영
        for (int k = 0; k < tmp.length; k++) {
            input[from + k] = tmp[k];
        }
    }

    private static void saveState(int[] input, int from, int[] tmp, int t) {
        found = true;
        result = input.clone(); // 배열 전체 복사
        for (int k = 0; k < t; k++) {
            result[from + k] = tmp[k]; // 중간 상태 반영
        }
    }
}
