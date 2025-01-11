import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int number = 666;
        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }
            if (count == n) {
                break;
            }
            number++;
        }
        bw.write(String.valueOf(number));
        bw.flush();
        bw.close();
    }
}