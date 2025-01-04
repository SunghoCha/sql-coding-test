import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] doubles = new double[n];
        for (int i = 0; i < n; i++) {
            doubles[i] = Double.parseDouble(st.nextToken());
        }
        double max = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += doubles[i];
            if (doubles[i] > max) {
                max = doubles[i];
            }
        }

        double score = sum / max * 100 / n;
        
        bw.write(String.valueOf(score));
        bw.flush();
        bw.close();
        br.close();
    }
}