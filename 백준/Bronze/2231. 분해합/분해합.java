import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
            수가 주어짐. 각 자리수의 합과 생성자 수. 생성자수의 최소값과 최대값 -> 탐색범위?
            가장 크다면 각자리수를 1로 잡아서 N -(자리수 * 1) ? 그냥 N보다 작다고 표현?
            가장 작다면 각자리수를 9로 잡아서 N -(자리수 * 9) ? 그냥 N보다 작다고 표현?

         */

        int n = Integer.parseInt(br.readLine());
        String str = String.valueOf(n);


        int min = Integer.MAX_VALUE;
        for (int m = n - (str.length() * 9); m < n; m++) {
            Integer sum = calculateSum(m);
            if (n == m + sum && m < min) {
                min = m;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    private static Integer calculateSum(int m) {
        int sum = 0;
        String newStr = String.valueOf( m);
        for (Character ch : newStr.toCharArray()) {
            sum += Character.getNumericValue(ch);
        }

        return sum;
    }
}