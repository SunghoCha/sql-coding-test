


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int number = Integer.parseInt(st.nextToken());
            map.put(number, map.getOrDefault(number , 0) + 1);
        }

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            Integer result = map.getOrDefault(Integer.parseInt(st.nextToken()), 0);
            sb.append(result).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }



}

