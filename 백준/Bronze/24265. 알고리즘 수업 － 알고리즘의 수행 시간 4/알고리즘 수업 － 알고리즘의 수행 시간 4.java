import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int n = Integer.parseInt(br.readLine());

        // 수행 횟수 계산
        long executionCount = (long) n * (n - 1) / 2; // n(n-1)/2

        // 출력
        System.out.println(executionCount); // 수행 횟수
        System.out.println(2); // 최고차항 차수
    }
}