import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(i, str.substring(i, i + 1));
        }
        int index = Integer.parseInt(br.readLine()) - 1;

        bw.write(list.get(index));
        bw.flush();
        bw.close();
        br.close();
    }
}