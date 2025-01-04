import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= total; i++) {
            if (target == Integer.parseInt(st.nextToken())) {
                count++;
            }
        }


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}