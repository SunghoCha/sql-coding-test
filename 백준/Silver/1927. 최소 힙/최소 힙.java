import java.util.*;
import java.io.*;

public class Main {
    
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                long result = Heap.poll();
                sb.append(result).append("\n");
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
        
        public static long poll() {
            if (heap.isEmpty()) {
                return 0;
            }
            long result = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapify(0);
            
            return result;
        }
        
        public static void add(long value) {
            heap.add(value);
            siftUp(heap.size() - 1);
        }
        
        // 최소힙
        private static void heapify(int index) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            
            int n = heap.size();
            if (left < n && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < n && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }
            if (smallest != index) {
                swap(smallest, index);
                heapify(smallest);
            }
        }
        
        private static void swap(int a, int b) {
            long temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }
        
        private static void siftUp(int index) {
            while (index > 0 && heap.get((index - 1) / 2) > heap.get(index)) {
                int parent = (index - 1) / 2;
                swap(index, parent);
                index = parent;
            }
        }
       
    }
}