


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int num = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        int[][] input1 = new int[x1][y1];
        for (int i = 0; i < x1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y1; j++) {
                input1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int[][] input2 = new int[x2][y2];
        for (int i = 0; i < x2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y2; j++) {
                input2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[x1][y2];
        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y2; j++) {
                for (int k = 0; k < y1; k++) {
                    result[i][j] += input1[i][k] * input2[k][j];
                }
            }
        }

        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y2; j++) {
                if (j == y2 - 1) {
                    sb.append(result[i][j]);
                } else {
                    sb.append(result[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }




}