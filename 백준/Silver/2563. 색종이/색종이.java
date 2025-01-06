import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        int[][] array = new int[100][100];
        int sum = 0;

        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (array[j][k] != 1) {
                        array[j][k] = 1;
                        sum++;
                    }
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }

}
