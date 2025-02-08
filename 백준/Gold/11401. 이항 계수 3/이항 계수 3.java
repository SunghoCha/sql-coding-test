


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int num = 1000000007;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        /*
            n! (n-k)! k!
         */
        long[] factorials = new long[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i % num;
        }

        long n1 = factorials[n];
        long d1 = factorials[n - k] * factorials[k] % num;

        long d2 = modPow(d1, num - 2);

        long result = (n1 * d2) % num;


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static long modPow(long d1, int p) {
        if (p == 0) {
            return 1;
        }
        long half = modPow(d1, p / 2);
        half = (half * half) % num;

        return (p % 2 ==0) ? half : (d1 * half) % num;
    }


}