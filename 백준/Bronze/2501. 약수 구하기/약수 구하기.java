import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int num = 1;
        while (p >= num) {
            if (p % num == 0) {
                list.add(num);
            }
            num++;
        }

        Integer result = 0;
        if (list.size() >= q) {
            result = list.get(q - 1);
        }

        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();
    }

}