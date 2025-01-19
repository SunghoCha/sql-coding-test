


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // 1. n0에서의 조건 확인
        boolean condition1 = (a1 * n0 + a0) >= (c * n0);

        // 2. 기울기 비교 확인
        boolean condition2 = a1 >= c;

        // 두 조건 모두 만족하면 1, 아니면 0 출력
        if (condition1 && condition2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }
}

