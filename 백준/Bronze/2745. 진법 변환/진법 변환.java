import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int sum = 0;
        int power = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(str.length() - (i + 1));
            int num;
            if (ch >= '0' && ch <= '9') {
                num = ch - '0';
            } else {
                num = ch - 'A' + 10;
            }
            sum += num * power;
            power *= n;
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

}