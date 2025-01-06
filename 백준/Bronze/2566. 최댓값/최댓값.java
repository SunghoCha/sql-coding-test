import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] array = new int[9][9];

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                array[i][j] = i1;
            }
        }
        int max = -1;
        int x = -1;
        int y = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] > max) {
                   max = array[i][j];
                   x = i + 1;
                   y = j + 1;
                }
            }
        }
        sb.append(max).append("\n");
        sb.append(x).append(" ").append(y);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}