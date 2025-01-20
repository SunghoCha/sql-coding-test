


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


        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] input = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        /*
            선택 삽입 병합 퀵
         */

        for (int i = 0; i < size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < size; j++) {
                if (input[j] > max) {
                    max = input[j];

                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }

        sb.append(input[k-1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}

