


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {

    private static StringBuilder sb;
    private static int[] dp1;
    private static int[] input1;
    private static int[] input2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        input1 = new int[num];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);
        }

        int idx = 0;
        for (Integer value : map.values()) {
            input1[idx] = value;
            idx++;
        }

        // LIS
        dp1 = new int[num];
        for (int i = 0; i < num; i++) {
            dp1[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input1[j] < input1[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < num; i++) {
            if (dp1[i] > max) {
                max = dp1[i];
            }
        }


        bw.write(String.valueOf(num - max));
        bw.flush();
        bw.close();
    }

}