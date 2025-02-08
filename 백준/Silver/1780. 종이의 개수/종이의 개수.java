


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[][] input;
    private static int a;
    private static int b;
    private static int c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        input = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate(0, 0, size);

        sb.append(a).append("\n").append(b).append("\n").append(c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void calculate(int x, int y, int size) {

        if (isSamePattern(x, y, size)) {
            int pattern = input[x][y];
            if (pattern == -1) {
                a++;
            } else if (pattern == 0) {
                b++;
            } else if (pattern == 1) {
                c++;
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                calculate(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }

    private static boolean isSamePattern(int x, int y, int size) {
        int number = input[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (input[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }


}