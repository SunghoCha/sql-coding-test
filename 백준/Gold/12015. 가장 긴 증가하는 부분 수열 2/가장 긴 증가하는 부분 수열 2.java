
import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> target = new ArrayList<>();
        target.add(input[0]);
        for (int i = 1; i < N; i++) {
            int index = biSearch(target, input[i]); // input의 요소를 대입했을 때 target에 추가해야할 인덱스 반환
            if (index != -1 && index < target.size()) {
                target.set(index, input[i]);
            } else if (index != -1) {
                target.add(input[i]);
            }
        }

        bw.write(String.valueOf(target.size()));
        bw.flush();
        bw.close();

    }

    public static int biSearch(List<Integer> target, int value) {
        int left = 0;
        int right = target.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target.get(mid) > value) {
                right = mid - 1;
            } else if (target.get(mid) < value) {
                left = mid + 1;
            } else {
                return -1; // 이미 존재하는 값이고 배열 뒤쪽에 있는 값이므로 쓸모없음
            }
        }
        return left; // 같은 인덱스에 있던 기존 값 대신 value를 넣기 위함
    }
}