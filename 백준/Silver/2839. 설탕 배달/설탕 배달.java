
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        /*
            최대한 5로 나눈 개수 많이 가져가고 안되면 -- 하면서..
         */
        int i = 0;
        int a = 0;
        int b = 0;
        int result = -1;
        while (true) {
            a = (n / 5) - i;
            if (a < 0) {
                break;
            }
            
            b = (n - a * 5) / 3;
            if ( 5 * a + 3 * b == n) {
                result = a + b;
                break;
            }
            i++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
