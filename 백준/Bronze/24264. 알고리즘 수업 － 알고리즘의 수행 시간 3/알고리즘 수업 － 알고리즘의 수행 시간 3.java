import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long i =(long) n * n;
        // 출력
        System.out.println(i); // 수행 횟수
        System.out.println(2); // 다항식의 최고차항 차수


    }

}