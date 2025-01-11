import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }


        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = j; i < n; i++) {
                if (ints[i] < min) {
                    min = ints[i];

                    int temp =  ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
            sb.append(min).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}