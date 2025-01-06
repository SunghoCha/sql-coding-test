import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            String str = br.readLine();
            if  (isGroupWord(str)) {
                count++;
            };
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isGroupWord(String str) {
        Set<Character> set = new HashSet<>();
        char prev = '\0';
        for (char ch : str.toCharArray()) {
            if (ch != prev) {
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
            prev = ch;
        }
        return true;
    }
}