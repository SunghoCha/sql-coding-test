import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int b1 = Integer.parseInt(s.substring(2, 3));
        int b2 = Integer.parseInt(s.substring(1, 2));
        int b3 = Integer.parseInt(s.substring(0, 1));

        int i1 = a * b1;
        int i2 = a * b2;
        int i3 = a * b3;

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i1 + i2 * 10 + i3 * 100);

    }
}