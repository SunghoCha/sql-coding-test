


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        long[] input = new long[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        long[] distance = new long[size - 1];
        for (int i = 1; i < input.length; i++) {
            distance[i - 1] = input[i] - input[i - 1];
        }

        long gcd = distance[0];
        for (int i = 1; i < distance.length; i++) {
            gcd = gcd(gcd, distance[i]);
        }

        long sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += (distance[i] / gcd) - 1;
        }


        bw.write(String.valueOf(sum));
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

