import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] array = new int[x][y];

        // 행렬 A
        int[][] arrayA = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < y; k++) {
                arrayA[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 행렬 B
        int[][] arrayB = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < y; k++) {
                arrayB[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j <y; j++) {
                array[i][j] = arrayA[i][j] + arrayB[i][j];
                sb.append(array[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}