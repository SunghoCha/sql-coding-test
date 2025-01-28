


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static int[] signs = new int[4];
    ;
    private static int[] input;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        input = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            signs[i] = Integer.parseInt(st.nextToken());
        }



        /*
          상태는 연산의 인덱스
          연산의 마지막 인덱스를 베이스조건
          for문은 연산자 배열의 요소
          앞에서 계산된 결과를 result에 담고 전달해서 다음 연산자와 다음 숫자와 계산(첫 result에는 첫 숫자)
          => backTrack() 인자는 상태인 연산의 인덱스와 result.
         */
        backTrack(input[0], 1);

        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    /*
        sign의 int값 그대로 가져가는게 맞나?
        한 번 가공해야?
        String 배열로?
     */
    private static void backTrack(int result, int index) {
        // index는 마지막 인덱스거나 초과한 인덱스
        if (index == input.length) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] > 0) {
                signs[i]--;

                int nextResult = result;
                if (i == 0) {
                    nextResult += input[index];
                } else if (i == 1) {
                    nextResult -= input[index];
                } else if (i == 2) {
                    nextResult *= input[index];
                } else if (i == 3) {
                    if (nextResult < 0) {
                        nextResult = -1 * (Math.abs(nextResult) / input[index]);
                    } else {
                        nextResult /= input[index];
                    }
                }
                backTrack(nextResult, index + 1);
                signs[i]++;
            }
        }
    }

}
