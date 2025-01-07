import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (isPrimeNumber(i)) {
                list.add(i);
            }
        }

        int sum = 0;
        int min = 99999999;
        for (Integer i : list) {
            sum += i;
            if (i < min) {
                min = i;
            }
        }
        if (list.isEmpty()) {
            sb.append(-1);
        } else {
            sb.append(sum).append("\n").append(min);
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static boolean isPrimeNumber(int num) {
        int a = 1;
        int count = 0;
        while (a <= num) {
            if (num % a == 0) {
                count++;
            }
            a++;
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

}