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
        int change = Integer.parseInt(st.nextToken());

        int temp = 0;
        int[] ints = new int[total];
        for (int i = 0; i < total; i ++) {
            ints[i] = i+1;
        }
        for (int i = 0; i < change; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken()) - 1;
            int i2 = Integer.parseInt(st.nextToken()) - 1;
            temp = ints[i1];
            ints[i1] = ints[i2];
            ints[i2] = temp;
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