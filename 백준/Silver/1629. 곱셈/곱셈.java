


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = calculate(a, b, c);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static long calculate(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        long half = calculate(a, b / 2, c);
        half = (half * half) % c;

        if (b % 2 == 0) {
            return half;
        } else {
            return (a * half) % c;
        }
    }


}