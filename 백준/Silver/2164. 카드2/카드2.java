


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        int result = calcuate(size);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

    /*
        1. pop
        2. pop + (rear 자리에 추가)

     */
    private static int calcuate(int size) {
        CircularQueue queue = new CircularQueue(size);
        for (int i = 1 ; i <= size; i++) {
            queue.push(i);
        }
        while (queue.size() != 1) {
            queue.pop();
            int pop = queue.pop();
            queue.push(pop);
        }
        return queue.pop();
    }

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

        public int size() {
            return this.size;
        }


    }

}


