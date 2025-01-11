import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 보드 생성
        char[][] chars = new char[x][y];
        for (int i = 0; i < x; i++) {
                chars[i] = br.readLine().toCharArray();
        }

        // 입력받은 보드와 비교
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= x - 8; i++) {
            for (int j = 0; j <= y - 8; j++) {
                // 비교해서 count 계산
                result = Math.min(result, calculateCounts(chars, i, j));
            }
        }


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static Integer calculateCounts(char[][] chars, int startX, int startY) {
        char[][] pattern1 = createPattern('W');
        char[][] pattern2 = createPattern('B');
        int count1 = 0;
        int count2 = 0;
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (chars[k + startX][l + startY] == pattern1[k][l]) {count1++;}
                if (chars[k + startX][l + startY] == pattern2[k][l]) {count2++;}
            }
        }
        return Math.min(count1, count2);
    }

    private static char[][] createPattern(char startColor) {
        char[][] patterns = new char[8][8];
        char otherColor = (startColor == 'W') ? 'B' : 'W';

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                patterns[i][j] = (i + j) % 2 == 0 ? startColor : otherColor;
            }
        }

        return patterns;
    }
}
