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
        for (int last = size - 1; last >= 1; last--) {
            for (int i = 0; i < last; i++) {
                if (input[i] > input[i + 1]) {
                    count++;
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;

                    if (count == tryNum) {
                        for (int i1 : input) {
                            sb.append(i1).append(" ");
                        }
                        bw.write(sb.toString().trim());
                        bw.flush();
                        bw.close();
                        return;
                    }
                }
            }
        }
        bw.write("-1");
        bw.flush();
        bw.close();

    }

}