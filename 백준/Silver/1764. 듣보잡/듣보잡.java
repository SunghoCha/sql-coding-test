


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);
        for (String s : list) {
            sb.append(s).append("\n");
        }


        bw.write(list.size() + "\n");
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }

}

