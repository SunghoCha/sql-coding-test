

import java.io.*;
import java.util.Arrays;

public class Main {

    private static StringBuilder sb;
    private static int result1 = 0;
    private static int result2 = 0;
    private static int num = 1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

//        for (int i = 0; i < size; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = i; j < size; j++) {
//                if (input[j] < min) {
//                    min = input[j];
//
//                    int tmp = input[i];
//                    input[i] = input[j];
//                    input[j] = tmp;
//                }
//            }
//            sb.append(i).append("\n");
//        }

        Arrays.sort(input);
        for (int i : input) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}

