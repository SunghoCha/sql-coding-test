import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double num = Double.parseDouble(br.readLine());
        double count = Math.ceil(num / 4);

        for (int i = 1; i <= count; i++) {
            bw.append("long").append(" ");
        }
        bw.append("int");
        bw.flush();

    }
}