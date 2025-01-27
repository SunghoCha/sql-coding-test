

import java.io.*;

public class Main {

    private static int count;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, size) - 1).append("\n");


        /*
            3개의 장대
            결국 가장 큰 원반이 3번 장대에 옮겨지기 위해선
            2번 장대(3번이 아닌 장대)에 나머지 1 ~ N - 1번의 원반이 순서대로 옮겨진 상태여야함

            1 ~ N - 2 / 1 ~ N - 3 ... 1 ~ 2 / 1 ~ 1

            임시장대라는건 3번을 제외한 1번 2번이 번갈아 가면서 임시장대가 되는듯

            장대를 옮기는건 어떤 자료 구조를 이용하지?

         */

        moveDisk(size, 1, 3, 2);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void moveDisk(int size, int from, int to, int aux) {
        if (size == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        moveDisk(size - 1, from, aux, to);

        sb.append(from).append(" ").append(to).append("\n");

        moveDisk(size - 1, aux, to, from);
    }


}