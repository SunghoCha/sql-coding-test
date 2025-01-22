


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        List<String> list = new ArrayList<>();
        TreeMap<String, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(map);
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            if (entry.getValue().equals("enter")) {
                sb.append(entry.getKey()).append("\n");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }

}

