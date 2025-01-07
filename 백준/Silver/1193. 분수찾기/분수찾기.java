
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        
        int m;
        int d;
        int l = 1;
        int maxRoom = 1;
        while (num > maxRoom) {
            l++;
            maxRoom += l;
        }
        int interval = maxRoom - num;
        if (l % 2 == 0) {
            m = l - interval;
            d = 1 + interval;
        } else {
            d = l - interval;
            m = 1 + interval;
        }
        sb.append(m).append("/").append(d);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
