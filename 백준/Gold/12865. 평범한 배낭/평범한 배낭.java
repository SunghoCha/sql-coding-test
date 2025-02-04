

import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[] dp;
    private static int[] weights;
    private static int[] values;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        weights = new int[num];
        values = new int[num];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[limit + 1];
        for (int i = 0; i < num; i++) {
            int weight1 = weights[i];
            int value1 = values[i];
            for (int w = limit; w >= weight1; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight1] + value1);
            }
        }



        bw.write(String.valueOf(dp[limit]));
        bw.flush();
        bw.close();
    }

}