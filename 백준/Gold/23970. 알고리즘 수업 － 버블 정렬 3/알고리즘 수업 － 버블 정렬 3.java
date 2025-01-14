import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        int[] a = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();
        tmp = br.readLine().split(" ");
        int[] b = Arrays.stream(tmp).mapToInt(Integer::parseInt).toArray();

        if (Arrays.equals(a, b)) {
            System.out.println(1);
            return;
        }

        // boolean flag;
        for (int i = n - 1; i >= 1; i--) {
            // flag = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    // flag = false;
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    if (a[j] == b[j] && a[j + 1] == b[j + 1] && Arrays.equals(a, b)) {
                        System.out.println(1);
                        return;
                    }
                }
            }

            // if (flag) {
            //     break;
            // }
        }

        System.out.println(0);
    }
}