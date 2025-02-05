


import java.io.*;
import java.util.StringTokenizer;
import java.util.logging.Filter;


public class Main {

    private static StringBuilder sb;
    private static char[][] input;
    private static int[][] sum;
    private static long resultCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        /*
            체스판은 첫 패턴이 흰,검에 따라 2가지 패턴만 존재
            주어진 판을 2가지 패턴과 비교하면서 미스매치 카운팅해서 누적합 구하고 이 값을 활용해서 다른곳의 미스카운팅 개수 적어나감
            -> 가장적은 미스매치인 곳
         */

        input = new char[x][y];
        for (int i = 0; i < x; i++) {
            input[i] = br.readLine().toCharArray();
        }

        int[][] mismatchA = createPattern('W', x, y);
        int[][] mismatchB = createPattern('B', x, y);

        int[][] prefixA = new int[x][y];
        int[][] prefixB = new int[x][y];

        prefixA[0][0] = mismatchA[0][0];
        prefixB[0][0] = mismatchB[0][0];
        for (int i = 1; i < x; i++) {
            prefixA[i][0] = prefixA[i - 1][0] + mismatchA[i][0];
            prefixB[i][0] = prefixB[i - 1][0] + mismatchB[i][0];
        }

        for (int i = 1; i < y; i++) {
            prefixA[0][i] = prefixA[0][i - 1] + mismatchA[0][i];
            prefixB[0][i] = prefixB[0][i - 1] + mismatchB[0][i];
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                prefixA[i][j] = prefixA[i - 1][j] + prefixA[i][j - 1] - prefixA[i - 1][j - 1] + mismatchA[i][j];
                prefixB[i][j] = prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1] + mismatchB[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int result2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= x - k; i++) {
            for (int j = 0; j <= y - k; j++) {
                result = prefixA[i + k - 1][j + k - 1];
                result2 = prefixB[i + k - 1][j + k - 1];

                if (i > 0) {
                    result -= prefixA[i - 1][j + k - 1];
                    result2 -= prefixB[i - 1][j + k - 1];
                }

                if (j > 0) {
                    result -= prefixA[i + k - 1][j - 1];
                    result2 -= prefixB[i + k - 1][j - 1];
                }

                if (i > 0 && j > 0) {
                    result += prefixA[i - 1][j - 1];
                    result2 += prefixB[i - 1][j - 1];
                }
                min = Math.min(min, Math.min(result, result2));
            }
        }


        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static int[][] createPattern(char startChar, int x, int y) {
        int[][] mismatch = new int[x][y];

        if (startChar == 'W') {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    char expected = ((i + j) % 2 == 0) ? 'W' : 'B';
                    mismatch[i][j] = (input[i][j] == expected) ? 0 : 1;
                }
            }
        } else if (startChar == 'B') {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    char expected = ((i + j) % 2 == 0) ? 'B' : 'W';
                    mismatch[i][j] = (input[i][j] == expected) ? 0 : 1;
                }
            }
        }

        return mismatch;

    }


}