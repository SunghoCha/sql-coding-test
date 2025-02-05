


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[][] input;
    private static int[][] sum;
    private static long resultCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        
        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum = new int[size][size];
        sum[0][0] = input[0][0];
        for (int i = 1; i < size; i++) {
            sum[0][i] += sum[0][i - 1] + input[0][i];
            sum[i][0] += sum[i - 1][0] + input[i][0];
        }
        sum[0][1] = sum[0][0] + input[0][1];
        sum[1][0] = sum[0][0] + input[1][0];

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + input[i][j];
            }
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int result = sum[x2][y2];
            if (x1 > 0) {
                result -= sum[x1 - 1][y2];
            }
            if (y1 > 0) {
                result -= sum[x2][y1 - 1];
            }
            if (x1 > 0 && y1 > 0) {
                result += sum[x1 -1][y1 - 1];
            }
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}