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
        int total = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] ints = new int[total];
        for (int i = 0; i < num; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());
            int number = Integer.parseInt(st1.nextToken());
            for (int j = from - 1; j < to; j++) {
                ints[j] = number;
            }
        }
        for (int i = 0; i < total; i++) {
            sb.append(ints[i]).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}