

import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static int result1 = 0;
    private static int result2 = 0;
    private static int num = 1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fib(n);

        sb.append(result1 % num).append(" ").append(n - 2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void fib(int n) {
        int fir = 1;
        int sec = 1;
        if (n == 1 || n == 2) {
            result1 = 1;
        } else {
            for (int i = 3; i <= n; i++) {
                result1 = (fir + sec) % num;
                fir = sec;
                sec = result1;
            }
        }
    }


}

