
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int[] x = new int[3];
        int[] y = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int fx = 0;
        int fy = 0;
        for (int i = 0; i < 3; i++) {
            fx ^= x[i];
            fy ^= y[i];
        }
        sb.append(fx).append(" ").append(fy);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}