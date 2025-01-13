import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int[] inputs = new int[size];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            map.put(inputs[i], i);
        }

        int[] targets = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 상태와 비교
        if (Arrays.equals(inputs, targets)) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        // 정렬을 위한 복사본
        int[] sorted = inputs.clone();
        Arrays.sort(sorted);

        for (int last = size - 1; last >= 1; last--) {
            if (inputs[last] != sorted[last]) {
                // 교환 로직
                int maxIndex = map.get(sorted[last]);
                int temp = inputs[last];
                inputs[last] = inputs[maxIndex];
                inputs[maxIndex] = temp;

                // `map` 업데이트
                map.put(inputs[maxIndex], maxIndex);
                map.put(inputs[last], last);

                // 현재 상태 비교
                if (Arrays.equals(inputs, targets)) {
                    bw.write("1");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }

        // 끝까지 동일한 상태를 발견하지 못하면 0 출력
        bw.write("0");
        bw.flush();
        bw.close();
    }
}
