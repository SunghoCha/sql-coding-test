


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        CircularQueue queue = new CircularQueue(n);
        for (int i = 1; i <= n; i++) {
            queue.push(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                int pop = queue.pop();
                queue.push(pop);
            }

            int result = queue.pop();

            if (queue.isEmpty()) {
                sb.append(result);
            } else {
                sb.append(result).append(", ");
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    /*
        1. pop
        2. push
        3. pop
        4. push
        5. pop

     */

    public static class CircularQueue {
        private int[] queue;
        private int capacity;
        private int size;
        private int front;
        private int rear;

        public CircularQueue(int capacity) {
            this.queue = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
            this.front = 0;
            this.rear = 0;
        }

        public void push(int value) {
            if (size == capacity) {
                throw new IllegalStateException("큐가 가득 참");
            }
            queue[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }

        public int pop() {
            if (size == 0) {
                throw new IllegalStateException("큐가 비어 있음");
            }
            int value = queue[front];
            front = (front + 1) % capacity;
            size--;

            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int front() {
            return queue[front];
        }

        public int back() {
            return queue[(rear - 1 + capacity) % capacity];
        }
    }

}


