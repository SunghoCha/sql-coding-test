import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char ch = br.readLine().charAt(0);

        int ch1 = ch;
        bw.write(String.valueOf(ch1));
        bw.flush();
        bw.close();
        br.close();
    }
}