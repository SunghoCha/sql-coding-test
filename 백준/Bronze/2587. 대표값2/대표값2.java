


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;
    private static int result1 = 0;
    private static int result2 = 0;
    private static int num = 1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        
        int[] input = new int[5];

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }

        Arrays.sort(input);
        sb.append(sum/5).append(" ").append(input[5/2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}

