import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputs = new int[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[size];
        for (int i = 0; i < size; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        /*
           정렬을 반복할때마다 targets와 같은지 비교
         */
        if(isSame(inputs, targets)) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }
        
        for (int last = size - 1; last >= 1; last--) {
            int maxIndex = 0;
            // 해당 배열에서 가장 큰 값을 가지는 인덱스 찾기
            for (int i = 0; i <= last; i++) {
                if (inputs[i] > inputs[maxIndex]) {
                    maxIndex = i;
                }
            }

            // 찾은 인덱스값이 last 인덱스가 아니면 교환
            if (maxIndex != last) {
                int temp = inputs[maxIndex];
                inputs[maxIndex] = inputs[last];
                inputs[last] = temp;
            }

            if (isSame(inputs, targets)) {
                bw.write("1");
                bw.flush();
                bw.close();
                return;
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