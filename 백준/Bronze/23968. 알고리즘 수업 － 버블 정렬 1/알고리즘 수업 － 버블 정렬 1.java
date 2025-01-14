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

        st = new StringTokenizer(br.readLine());
        int[] input = new int[size];
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
                        sb.append(input[i]).append(" ").append(input[i + 1]);
                        bw.write(sb.toString());
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