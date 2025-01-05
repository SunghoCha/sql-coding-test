import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int start = 0;
        int end = str.length() - 1; 
        int result = 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                result = 0;
            }
            start++;
            end--;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}