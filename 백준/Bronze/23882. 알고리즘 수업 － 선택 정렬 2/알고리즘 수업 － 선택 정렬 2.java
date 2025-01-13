import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int tryNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int last = size - 1; last >= 1; last--) {
            int maxIndex = 0;
            for (int i = 0; i <= last; i++) {
                if (ints[i] > ints[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (maxIndex != last) {
                count++;

                int temp = ints[maxIndex];
                ints[maxIndex] = ints[last];
                ints[last] = temp;

                if (count == tryNum) {
                    for (int anInt : ints) {
                        sb.append(anInt).append(" ");
                    }
                }
            }
        }
        if (count < tryNum) {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}