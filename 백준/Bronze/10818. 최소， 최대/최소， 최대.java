import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 999999999;
        int max = -999999999;
        for (int i = 1; i <= total; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            if (i1 < min) {
                min = i1;
            }
            if (i1 > max) {
                max = i1;
            }
        }
        sb.append(min).append(" ").append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}