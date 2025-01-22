


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            long l = Long.parseLong(br.readLine());
            long result = findPrime(l);
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static long findPrime(long a) {
        while (!isPrime(a)) {
            a++;
        }
        return a;
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (long i = 3; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }



}

