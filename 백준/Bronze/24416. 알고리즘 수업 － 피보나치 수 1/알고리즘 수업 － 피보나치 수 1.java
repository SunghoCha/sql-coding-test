

import java.io.*;

public class Main {

    private static StringBuilder sb;
    private static int result1 = 0;
    private static int result2 = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);
        sb.append(result1).append(" ").append(result2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            result1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            result2++;
        }
        return f[n];
    }
}

