import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

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

        /*
           정렬을 반복할때마다 targets와 같은지 비교
         */
        if (isSame(inputs, targets)) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        // 정렬 최적화용 배열
        int[] sorted = inputs.clone();
        Arrays.sort(sorted);

        for (int last = size - 1; last >= 1; last--) {
            // 비교 후 교체 로직
            if (inputs[last] != sorted[last]) {
                int maxIndex = map.get(sorted[last]);
                int temp = inputs[last];
                inputs[last] = inputs[maxIndex];
                inputs[maxIndex] = temp;

                map.put(inputs[last], last);
                map.put(inputs[maxIndex], maxIndex);


                // 교체 후 target과 비교
                if (isSame(inputs, targets)) {
                    bw.write("1");
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        bw.write("0");
        bw.flush();
        bw.close();
    }

    private static boolean isSame(int[] inputs, int[] targets) {
        if (inputs.length != targets.length) {
            return false;
        }

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] != targets[i]) {
                return false;
            }
        }
        return true;
    }
}