import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int t = m + time;
        int t1 = t / 60;
        int t2 = t % 60;

        /*
            time이 주어지면서 생기는 알고리즘
            m + time이 60을 넘지 않는지 넘는지
            넘는다면 추가된 시간에 따라 h값을 바꿔줘야함.
            h값이 24 이상인지 아닌지

         */

        if (t >= 60) {
            h += t1;
            m = t2;
            if (h >= 24) {
                h = h % 24;
            }
        } else {
            m = m + time;
        }

        System.out.println(h + " " + m);

    }
}

