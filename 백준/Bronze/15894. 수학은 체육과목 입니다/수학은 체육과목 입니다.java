import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long i = Integer.parseInt(br.readLine());
        long result = 4 * i;

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}