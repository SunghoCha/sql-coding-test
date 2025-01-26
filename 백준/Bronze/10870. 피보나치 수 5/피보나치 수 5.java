


import java.io.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        long result = fibo(n);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();


    }

    private static long fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}