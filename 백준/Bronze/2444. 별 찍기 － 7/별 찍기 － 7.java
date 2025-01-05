import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int total = (2 * n) - 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        int m = n - 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(" ");
            }
            for (int k = 2 * m - 1; k >= 2 * i - 1; k--) {
                sb.append("*");
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}