


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[][] input;
    private static int white;
    private static int blue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(split[j]);
            }
        }

        calculate(0, 0, size);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void calculate(int x, int y, int size) {



        if (isSamePattern(x, y, size)) {
            int pattern = input[x][y];
            sb.append(pattern);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        calculate(x, y, newSize);
        calculate(x, y + newSize, newSize);
        calculate(x + newSize, y, newSize);
        calculate(x + newSize, y + newSize, newSize);
        sb.append(")");

    }

    private static boolean isSamePattern(int x, int y, int size) {
        int pattern = input[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (input[i][j] != pattern) {
                    return false;
                }
            }
        }

        return true;
    }


}