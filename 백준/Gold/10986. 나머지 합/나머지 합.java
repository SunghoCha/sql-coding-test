


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static int[] modCount;
    private static int[] sum;
    private static long resultCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        sum = new int[size];

        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken()) % num;

        for (int i = 1; i < size; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken())) % num;
        }

        modCount = new int[num];
        for (int i = 0; i < size; i++) {
            int idx = sum[i];
            if (idx == 0) {
                resultCount++;
            }
            resultCount += modCount[idx];
            modCount[idx]++;
        }

        bw.write(String.valueOf(resultCount));
        bw.flush();
        bw.close();
    }


}