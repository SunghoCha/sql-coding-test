import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
