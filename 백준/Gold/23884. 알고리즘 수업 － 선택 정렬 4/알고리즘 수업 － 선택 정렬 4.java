import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
            map.put(ints[i], i);
        }
        int[] sorted = ints.clone();
        Arrays.sort(sorted);

        int count = 0;

        for (int last = size - 1; last >= 1; last--) {
            /*
               마지막 인덱스를 확인해서 정렬이 안된 경우에만 정렬을 시도
               이미 정렬된 인덱스 배열과 비교
             */
            if (ints[last] != sorted[last]) {
                /*
                    값에 중복이 없다고 가정
                    값으로 인덱스를 찾아서 인덱스 교환 (맵 활용)
                 */

                count++;
                int temp = ints[last];
                Integer maxIndex = map.get(sorted[last]);
                ints[last] = ints[maxIndex];
                ints[maxIndex] = temp;

                map.put(ints[last], last);
                map.put(ints[maxIndex], maxIndex);

                if (count == tryNum) {
                    for (int anInt : ints) {
                        sb.append(anInt).append(" ");
                    }
                }
            }
        }
        if (count < tryNum) {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}
