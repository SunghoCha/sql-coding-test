


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;
    private static Deck deck;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        deck = new Deck(size);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            Node node = new Node(i, Integer.parseInt(st.nextToken()));
            deck.pushBack(node);
        }

        while (!deck.isEmpty()) {
            Node node = deck.getFront();
            sb.append(node.getIndex()).append(" ");
            int number = node.getNumber();
            calculate(node.index, number);
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();


    }

    private static void calculate(int index, int number) {

        deck.popFront();
        if (!deck.isEmpty()) {
            if (number >= 0) {
                for (int i = 1; i < number; i++) {
                    deck.pushBack(deck.popFront());
                }
            } else {
                for (int i = 1; i <= Math.abs(number); i++) {
                    deck.pushFront(deck.popBack());
                }
            }
        }
    }

    public static class Node {
        private int index;
        private int number;

        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public int getNumber() {
            return number;
        }
    }

    public static class Deck {
        private Node[] deck;
        private int capacity;
        private int size;
        private int front;
        private int rear;

        public Deck(int capacity) {
            this.deck = new Node[capacity];
            this.capacity = capacity;
            this.size = 0;
            this.front = 0;
            this.rear = 0;
        }

        public void pushFront(Node value) {
            if (size == capacity) {
                throw new IllegalStateException("큐가 가득 참");
            }
            front = (front - 1 + capacity) % capacity;
            deck[front] = value;
            size++;
        }

        public void pushBack(Node value) {
            if (size == capacity) {
                throw new IllegalStateException("큐가 가득 참");
            }
            deck[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }

        public Node popFront() {
            if (size == 0) {
                throw new IllegalStateException("큐가 비어있음");
            }
            Node value = deck[front];
            front = (front + 1) % capacity;
            size--;

            return value;

        }

        public Node popBack() {
            if (size == 0) {
                throw new IllegalStateException("큐가 비어 있음");
            }
            rear = (rear - 1 + capacity) % capacity;
            Node value = deck[rear];
            size--;

            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public Node getFront() {
            if (size == 0) {
                throw new IllegalStateException("덱이 비었음");
            }
            return deck[front];
        }

        public Node getBack() {
            if (size == 0) {
                throw new IllegalStateException("덱이 비었음");
            }
            int back = (rear - 1 + capacity) % capacity;
            return deck[back];
        }
    }

}