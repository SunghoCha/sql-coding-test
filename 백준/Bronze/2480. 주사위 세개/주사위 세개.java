import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> list = List.of(a, b, c);
        int money = 0;

        if (a == b && b == c) {
          money = 10000 + 1000 * a;
        } else if (a == b || b == c || a == c) {
            if (a == b) {
                money = 1000 + 100 * a;
            } else if (b == c) {
                money = 1000 + 100 * b;
            } else if (a == c) {
                money = 1000 + 100 * c;
            }
        } else if (a != b && b != c) {
            Integer i = list.stream().max(Comparator.comparing(Integer::intValue)).orElse(0);
            money = 100 * i;
        }
        System.out.println(money);

    }
}