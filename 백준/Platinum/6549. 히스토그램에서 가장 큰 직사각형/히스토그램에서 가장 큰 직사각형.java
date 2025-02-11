import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb;
    private static long[] heights;
    private static long maxArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break; // 입력이 0이면 종료

            heights = new long[n];

            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }

            maxArea = getMaxArea(n);
            sb.append(maxArea).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long getMaxArea(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            // 현재 높이가 이전보다 낮다면, 스택에서 pop하면서 최대 사각형을 계산
            while (!deque.isEmpty() && heights[i] < heights[deque.peek()]) {
                int heightIndex = deque.pop();
                long height = heights[heightIndex];
                int width = deque.isEmpty() ? i : i - deque.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            deque.push(i);
        }

        // 스택에 남아있는 요소 처리
        while (!deque.isEmpty()) {
            int heightIndex = deque.pop();
            long height = heights[heightIndex];
            int width = deque.isEmpty() ? n : n - deque.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
