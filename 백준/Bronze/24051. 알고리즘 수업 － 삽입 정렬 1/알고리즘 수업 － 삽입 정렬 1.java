import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int tryNum = Integer.parseInt(st.nextToken());

        int[] input = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i < input.length; i++) {
            int loc = i - 1;
            int newItem = input[i];
            while (loc >= 0 && newItem < input[loc]) {
                input[loc + 1] = input[loc];
                loc--;
                count++;
                if (count == tryNum) {
                    sb.append(input[loc + 1]);
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            }
            if (loc + 1 != i) {
                input[loc + 1] = newItem;
                count++;
                if (count == tryNum) {
                    sb.append(input[loc + 1]);
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        if (count < tryNum) {
            bw.write("-1");
            bw.flush();
            bw.close();
        }

    }
}