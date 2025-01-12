import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int tryNum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0; // 교환 횟수
        for (int last = size - 1; last >= 1; last--) {
            int maxIndex = last; // 최대값의 인덱스
            for (int i = 0; i <= last; i++) {
                if (ints[i] > ints[maxIndex]) {
                    maxIndex = i;
                }
            }

            // 최대값이 현재 위치에 없으면 교환
            if (maxIndex != last) {
                count++;
                int temp = ints[last];
                ints[last] = ints[maxIndex];
                ints[maxIndex] = temp;

                // K번째 교환 시, 교환된 값을 출력
                if (count == tryNum) {
                    int first = Math.min(ints[last], ints[maxIndex]);
                    int second = Math.max(ints[last], ints[maxIndex]);
                    sb.append(first).append(" ").append(second);
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return; // 프로그램 종료
                }
            }
        }

        // K번째 교환이 이루어지지 않은 경우
        if (count < tryNum) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
