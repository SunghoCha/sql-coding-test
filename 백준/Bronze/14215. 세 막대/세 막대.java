import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        list.add(a);
        list.add(b);
        list.add(c);

        Collections.sort(list);

        if (list.get(2) >= list.get(0) + list.get(1)) {
            list.set(2, list.get(0) + list.get(1) - 1);
        }

        int result = list.stream().mapToInt(Integer::intValue).sum();
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}