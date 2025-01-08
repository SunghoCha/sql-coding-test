import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            max = Math.max(a, Math.max(b, c));

            if ((a+b+c) - max <= max) {
                sb.append("Invalid").append("\n");
            } else if (a == b && b == c) {
                sb.append("Equilateral").append("\n");
            } else if (a == b || a == c || b == c) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }


        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

}