import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String str = s.toUpperCase();
        String result;
        boolean isDuplicated = false;
        int[] ints = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int idx = ch - 'A';
            ints[idx]++;
        }
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < ints.length; i++) {
            int i1 = ints[i];
            if (i1 == max) {
                isDuplicated = true;
            } else if (i1 > max) {
                isDuplicated = false;
                max = i1;
                maxIdx = i;
            }
        }
        char i1 = '?';
        if (!isDuplicated) {
            int i = 'A' + maxIdx;
            i1 = (char) i;
        }

        bw.write(String.valueOf(i1));
        bw.flush();
        bw.close();
        br.close();
    }
}