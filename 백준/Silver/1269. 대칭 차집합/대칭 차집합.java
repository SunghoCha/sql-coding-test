


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size1; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size2; i++) {
            int i1 = Integer.parseInt(st.nextToken());
            if (set.contains(i1)) {
                count++;
            }
        }
        int result = size1 + size2 - 2 * count;

        bw.write(String.valueOf(result));
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }

}

