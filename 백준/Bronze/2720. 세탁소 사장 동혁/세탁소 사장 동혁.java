
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            int price = Integer.parseInt(br.readLine());

            int i1 = price / 25;
            sb.append(i1).append(" ");
            price -= i1 * 25;

            int i2 = price / 10;
            sb.append(i2).append(" ");
            price -= i2 * 10;

            int i3 = price / 5;
            sb.append(i3).append(" ");
            price -= i3 * 5;

            int i4 = price;
            sb.append(i4).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}