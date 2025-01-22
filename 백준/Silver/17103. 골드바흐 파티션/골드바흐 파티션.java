


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        findPrime(1000000);

        for (int i = 0; i < size; i++) {
            int value = Integer.parseInt(br.readLine());
            int count = calculate(value);
            sb.append(count).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void findPrime(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int calculate(int value) {
        int count = 0;

        for (int i = 0; i < primes.size(); i++) {
            Integer p = primes.get(i);
            if (p > value / 2) {
                break;
            }
            int q = value - p;
            if (isPrime(q)) {
                count++;
            }
        }
        return count;
    }


}

