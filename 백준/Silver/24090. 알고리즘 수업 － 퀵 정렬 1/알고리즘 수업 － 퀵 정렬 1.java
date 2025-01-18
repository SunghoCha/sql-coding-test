import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static int result = 0;
    private static boolean flag = false;
    private static int[] target;
    private static int[] input;
    private static int idx = -1;
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
            bw.write(sb.toString());
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
            qSort(from, pivotIdx - 1);
            qSort(pivotIdx + 1, to);
        }
    }

    private static int partition(int from, int to) {
        int pivot = input[to];
        int i = from - 1;
        // pivot보다 작은 값들 왼쪽부터 채움
        for (int j = from; j < to; j++) {
            if (input[j] <= pivot) {
                int tmp = input[++i];
                input[i] = input[j];
                input[j] = tmp;
                count++;

                if (count == tryNum) {
                    flag = true;
                    sb.append(input[i]).append(" ").append(input[j]);
                    return i; // 그냥 아무값이나 반환하는느낌인가
                }
            }
        }
        // pivot 위치 업데이트
        if (i + 1 != to) {
            int tmp = input[i + 1];
            input[i + 1] = input[to];
            input[to] = tmp;
            count++;

            if (count == tryNum) {
                flag = true;
                sb.append(input[i + 1]).append(" ").append(input[to]);

            }
        }
        // pivot의 인덱스 반환
        return i + 1;
    }

}
