


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Integer.parseInt(st.nextToken());
        long a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long b1 = Integer.parseInt(st.nextToken());
        long b2 = Integer.parseInt(st.nextToken());

        long denominator = lcm(a2, b2);
        long c1 = a1 * (denominator / a2);
        long c2 = b1 * (denominator / b2);
        long numerator = c1 + c2;
        long gcd = gcd(denominator, numerator);
        numerator /= gcd;
        denominator /= gcd;
        sb.append(numerator).append(" ").append(denominator);

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

