


import java.io.*;
import java.util.StringTokenizer;


public class Main {

    private static StringBuilder sb;
    private static char[] chars;
    private static char[] input;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        chars = br.readLine().toCharArray();

        int size = Integer.parseInt(br.readLine());

        dp = new int[26][chars.length];

        input = new char[26];
        for (int i = 0; i < 26; i++) {
            input[i] = (char) ('a' + i);
        }

        for (int i = 0; i < 26; i++) {
            dp[i][0] = (chars[0] == input[i]) ? 1 : 0;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == input[i]) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int result;
            char[] charArray = s.toCharArray();
            if (chars[from] == input[charArray[0] - 'a']) {
                result = dp[charArray[0] - 'a'][to] - dp[charArray[0] - 'a'][from] + 1;
                sb.append(result).append("\n");
            } else {
                result = dp[charArray[0] - 'a'][to] - dp[charArray[0] - 'a'][from];
                sb.append(result).append("\n");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}