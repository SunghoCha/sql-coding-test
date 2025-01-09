import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 출력
        System.out.println(n); // 수행 횟수
        System.out.println(1); // 다항식의 최고차항 차수


        bw.flush();
        bw.close();
    }

}