import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 크로아티아 알파벳 목록
        String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 크로아티아 알파벳을 "*"로 대체
        for (String croatia : croatiaAlphabets) {
            input = input.replace(croatia, "*");
        }

        // 최종 문자열의 길이가 크로아티아 알파벳의 개수
        System.out.println(input.length());
    }
}
