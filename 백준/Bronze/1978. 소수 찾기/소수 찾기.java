import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrimeNumber(num)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();

        bw.close();
        br.close();
    }

    private static boolean isPrimeNumber(int num) {
        int a = 1;
        int count = 0;
        while (a <= num) {
            if (num % a == 0) {
                count++;
            }
            a++;
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

}