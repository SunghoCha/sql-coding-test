


import java.io.*;

public class Main {

    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        char[][] input = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                input[i][j] = ' ';
            }
        }
        recursionStar(input, 0, 0, size);

        for (char[] chars : input) {
            sb.append(chars).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void recursionStar(char[][] input, int x, int y, int size) {
        if (size == 1) {
            input[x][y] = '*';
            return;
        }
        int third = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                recursionStar(input, x + i * third, y + j * third, third);
            }
        }
    }



}