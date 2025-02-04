


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[] input;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        dp = new int[num];

        input = new int[num];
        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = input[0];
        for (int i = 1; i < num; i++) {
            dp[i] = dp[i - 1] + input[i];
        }
        
        
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            int result = dp[to] - dp[from] + input[from];

            sb.append(result).append("\n");
        }

        
        
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }



}