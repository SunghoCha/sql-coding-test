import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] booleans = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int i1 = Integer.parseInt(br.readLine());
            int a = i1 % 42;
            booleans[a] = true;
        }

        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (booleans[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}