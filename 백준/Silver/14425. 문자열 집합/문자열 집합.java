


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size1; i++) {
            map.put(br.readLine(), 1);
        }
        int sum = 0;
        for (int i = 0; i < size2; i++) {
            sum += map.getOrDefault(br.readLine(), 0);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }

}

