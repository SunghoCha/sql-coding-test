import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static int[] result;
    private static boolean flag;

    public static void main(String[] args) throws IOException {

        /*
            입력받은 배열을 절반으로 나눠서 다시 mergeSort 하는 재귀. sort된 배열들을 다시 조립
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        tryNum = Integer.parseInt(st.nextToken());

        int[] input = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int from = 0;
        int to = input.length - 1;
        mergeSort(input, from, to);

        if (count < tryNum) {
            bw.write("-1");
            bw.flush();
            bw.close();
        } else {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            bw.write(sb.toString().trim());
            bw.flush();
            bw.close();
        }
    }

    private static void mergeSort(int[] input, int from, int to) {
        if (from < to && !flag) {
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
                flag = true;
                result = input.clone();
                for (int k = 0; k < t; k++) {
                    result[from + k] = tmp[k];
                }
                return;
            }
        }
        while (i <= middle) {
            tmp[t++] = input[i++];
            count++;
            if (count == tryNum) {
                flag = true;
                result = input.clone();
                for (int k = 0; k < t; k++) {
                    result[from + k] = tmp[k];
                }
                return;
            }
        }
        while (j <= to) {
            tmp[t++] = input[j++];
            count++;
            if (count == tryNum) {
                flag = true;
                result = input.clone();
                for (int k = 0; k < t; k++) {
                    result[from + k] = tmp[k];
                }
                return;
            }
        }
        // return 이후에 이 반복문이 실행되나??
        for (int k = 0; k < tmp.length; k++) {
            input[from + k] = tmp[k];
        }
    }

}
