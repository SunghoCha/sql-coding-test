import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        // 소인수분해
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            }
        }

        // 남은 값이 1보다 크면 마지막 소수
        if (N > 1) {
            sb.append(N).append("\n");
        }

        System.out.print(sb);
    }
}
