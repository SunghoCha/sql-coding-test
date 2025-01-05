import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = List.of(1, 1, 2, 2, 2, 8);
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           sb.append(list.get(i) - Integer.parseInt(st.nextToken())).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}