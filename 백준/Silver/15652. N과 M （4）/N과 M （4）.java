


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] sequence;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        sequence = new int[M];
        int depth = 0;
        backTrack(1, depth);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void backTrack(int start, int depth) {
        if (depth == M) {
            for (int value : sequence) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            backTrack(i, depth + 1);
        }


    }
}