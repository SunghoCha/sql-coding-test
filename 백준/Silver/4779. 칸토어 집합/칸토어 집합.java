

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int num = (int) Math.pow(3, n);
            List<String> input = new ArrayList<>(Collections.nCopies(num, "-"));

            recursion(input, 0, num - 1);

            // 각 입력마다 새로운 StringBuilder 사용
            StringBuilder sb = new StringBuilder();
            for (String s : input) {
                sb.append(s);
            }

            // 결과 출력
            bw.write(sb.toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void recursion(List<String> input, int from, int to) {
        if (from == to) {
            return;
        }

        int length = to - from + 1;
        int third = length / 3;

        // 가운데 구간 공백 처리
        change(input, from + third, from + 2 * third - 1);

        // 양쪽 구간에 대해 재귀 호출
        recursion(input, from, from + third - 1);           // 첫 번째 구간
        recursion(input, from + 2 * third, to);             // 세 번째 구간
    }

    private static void change(List<String> input, int from, int to) {
        for (int i = from; i <= to; i++) {
            input.set(i, " ");
        }
    }
}
