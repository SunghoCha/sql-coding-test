


import java.io.*;
import java.sql.PreparedStatement;

public class Main {

    private static StringBuilder sb;
    private static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < size; i++) {
            char[] chars = br.readLine().toCharArray();
            count = 0;
            result = isPalindrome(chars);
            sb.append(result).append(" ").append(count).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }

    private static int isPalindrome(char[] chars) {
        return recursion(chars, 0, chars.length - 1);
    }

    private static int recursion(char[] chars, int from, int to) {
        count++;
        if (from >= to) {
            return 1;
        } else if (chars[from] != chars[to]) {
            return 0;
        } else {
            return recursion(chars, from + 1, to - 1);
        }

    }
}