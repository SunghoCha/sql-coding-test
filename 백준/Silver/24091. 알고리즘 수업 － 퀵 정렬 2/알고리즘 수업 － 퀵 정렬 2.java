import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static int result = 0;
    private static boolean flag = false;
    private static int[] target;
    private static int[] input;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        tryNum = Integer.parseInt(st.nextToken());

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        qSort(0, size - 1);

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

    private static void qSort(int from, int to) {
        if (from < to && !flag) {
            int pivotIdx = partition(from, to);
            qSort(from, pivotIdx -1);
            qSort(pivotIdx + 1, to);
        }
    }

    private static int partition(int from, int to) {
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
                    for (int value : input) {
                        sb.append(value).append(" ");
                    }
                    return i; // 피벗 인덱스 값은 아님..
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
                for (int value : input) {
                    sb.append(value).append(" ");
                }
            }
        }
        return i + 1;
    }

}