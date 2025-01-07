import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int i = Integer.parseInt(br.readLine());
            if (i == -1) {
                break;
            }

            int num = 1;
            List<Integer> list = new ArrayList<>();
            while (i > num) {
                if (i % num == 0) {
                    list.add(num);
                }
                num++;
            }

            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum == i) {
                List<String> strings = list.stream().map(String::valueOf).collect(Collectors.toList());
                String join = String.join(" + ", strings);
                sb.append(i).append(" = ").append(String.join(" + ", strings)).append("\n");
            } else {
                sb.append(i).append(" is NOT perfect.").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

}