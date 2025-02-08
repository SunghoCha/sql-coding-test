


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static long[][] input;
    private static int mod = 1000000007;
    private static long n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());

        initMatrix();

        long result = fibo(n);


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void initMatrix() {
        input = new long[2][2];
        input[0][0] = 1;
        input[0][1] = 1;
        input[1][0] = 1;
        input[1][1] = 0;
    }

    private static long fibo(long n) {
        if(n == 0) return 0;
        long[][] result = calculate(n);

        return result[0][1];
    }

    private static long[][] calculate(long n) {
        if (n == 1) {
            return input;
        }

        long[][] half = calculate(n / 2);
        long[][] result = powMatrix(half, half);

        return (n % 2 == 0) ? result : powMatrix(input, result);

    }

    private static long[][] powMatrix(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return result;
    }


}