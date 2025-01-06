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
        int num = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Character> list = new ArrayList<>();
        char ch;
        while (num != 0) {
            int m = num % n;
            if (m < 10) {
                ch = (char) (m + '0');
            } else {
                ch = (char) ((m - 10) + 'A');
            }
            list.add(ch);
            num /= n;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}