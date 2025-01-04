import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int max = -999999999;
        int pos = 1;
        for (int i = 1; i <= 9; i++) {
            int i1 = Integer.parseInt(br.readLine());
            if (i1 > max) {
                max = i1;
                pos = i;
            }
        }
        sb.append(max).append("\n").append(pos);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}