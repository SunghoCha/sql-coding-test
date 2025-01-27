


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int size;
    private static int num;
    private static boolean[] visited;
    private static int[] sequence;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        sequence = new int[size];
        backtrack(1,0);

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();


    }

    private static void backtrack(int start, int depth) {
        if (depth == size) {
            for (int value : sequence) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= num; i++) {
            sequence[depth] = i;
            backtrack(i + 1, depth + 1);

        }

    }

}