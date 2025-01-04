import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int temp = 0;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = i + 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) -1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            if (to % 2 != 0) {
                int end = (to / 2) + 1;
            } else {
                int end = to / 2;
            }
            int end = to;
            for (int j = from; j <= end; j++) {
                temp = ints[j];
                ints[j] = ints[end];
                ints[end] = temp;
                end--;
            }


        }
        for (int i = 0; i < n; i++) {
            sb.append(ints[i]).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}