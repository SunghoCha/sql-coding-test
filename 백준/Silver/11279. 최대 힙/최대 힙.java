


import java.util.*;
import java.io.*;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                long max = Heap.poll();
                sb.append(max).append("\n");
            } else {
                Heap.add(value);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static class Heap {
        private static List<Long> heap = new ArrayList<Long>();


        public static void add(long value) {
            heap.add(value);
            shiftUp(heap.size() - 1);
        }

        public static long poll() {
            if (heap.isEmpty()) {
                return 0;
            } else {
                long result = heap.get(0);
                heap.set(0, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                heapify(0);
                return result;
            }
        }

        public static void heapify(int k) {
            int n = heap.size();

            int largest = k;
            int left = 2 * k + 1;
            int right = 2 * k + 2;

            if (left < n && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < n && heap.get(right) > heap.get(largest)) {
                largest = right;
            }
            if (largest != k) {
                swap(largest, k);
                heapify(largest);
            }
        }

        public static void swap(int a, int b) {
            long temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }

        public static void shiftUp(int index) {
            // 해당 인덱스의 부모와 비교해서 내가 더 작을때까지. 부모의 인덱스는 어떻게찾지 left, right
            // 0인덱스 기준 left = 2 * 부모 + 1, right = 2 * 부모 + 2 이므로 (index - 1) / 2 = 부모

            // 인덱스가 0보다 크면서 부모보다 커야 계속 진행
            while (index > 0 && heap.get((index - 1) / 2) < heap.get(index)) {
                int parent = (index - 1) / 2;
                swap(index, parent);
                index = parent;
            }

        }
    }
}