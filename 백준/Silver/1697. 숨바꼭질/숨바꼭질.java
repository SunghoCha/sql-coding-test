


import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX_POSITION = 100001;
    private static StringBuilder sb;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[MAX_POSITION]; // 0 ~ 100000
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int result = bfs(start, target);
        
        bw.write(String.valueOf(result));
        bw.flush();

    }

    private static int bfs(int start, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        int count = 0; // 첫 위치는 0초일때의 위치

        while (!deque.isEmpty()) {

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int node = deque.poll();

                if (node == target) {
                    return count;
                }

                // node +1, -1 , *2
                int[] neighbors = new int[]{node - 1, node + 1, 2 * node};
                for (int position : neighbors) {
                    if (isValidPosition(position) && !visited[position]) {
                        deque.offer(position);
                        visited[position] = true;

                    }
                }

            }
            count++;
        }
        return -1;
    }

    private static boolean isValidPosition(int position) {
        return position >= 0 && position < MAX_POSITION;
    }


}