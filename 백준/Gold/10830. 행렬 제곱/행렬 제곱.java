


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[][] input;
    private static int mod = 1000;
    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long exp = Long.parseLong(st.nextToken());

        input = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                input[i][j] = Integer.parseInt(st.nextToken()) % mod;
            }
        }

        int[][] calculated = calculate(exp);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(calculated[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[][] calculate(long exp) {
        if (exp == 1) {
            return input;
        }

        int[][] half = calculate(exp / 2);
        int[][] halfSquared = modMatrix(half, half);

        return (exp % 2 == 0) ? halfSquared : modMatrix(input, halfSquared);
    }

    private static int[][] modMatrix(int[][] A, int[][] B) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j]  = (result[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return result;
    }


}