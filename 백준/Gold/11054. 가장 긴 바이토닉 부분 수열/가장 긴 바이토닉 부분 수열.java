


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[] dp1;
    private static int[] dp2;
    private static int[] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        input = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // LIS
        dp1 = new int[num];
        for (int i = 0; i < num; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // LDS
        dp2 = new int[num];
        for (int i = num - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = num - 1; j > i; j--) {
                if (input[j] < input[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int length = 0;
        for (int i = 0; i < num; i++) {
            length = Math.max(length, dp1[i] + dp2[i] - 1);
        }
        
        
        bw.write(String.valueOf(length));
        bw.flush();
        bw.close();
    }

}