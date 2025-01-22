


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long result = lcm(a, b);
        sb.append(result);


        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

}

