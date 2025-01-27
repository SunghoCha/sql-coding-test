


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int size;
    private static int num;
    private static boolean[] visited;
    private static int[] sequence;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        visited = new boolean[num + 1];
        sequence = new int[size];
        backtrack(0);

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();


    }

    private static void backtrack(int depth) {
        if (depth == size) {
            for (int value : sequence) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= num; i++) {
            /*
                1. 값 추가
                backtrack 재귀로 하는데, 값 중복체크하기 위한 visited 체크
                체크 후 sequence에 추가.

                2. 다음자리 값 추가
                backtrack (재귀)

                3. 다음 for문 전에 visited 초기화 (sequence는 계속 덮어쓰기 되므로 초기화 필요 x)

             */
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                backtrack(depth +1);
                visited[i] = false;
            }
        }

    }

}