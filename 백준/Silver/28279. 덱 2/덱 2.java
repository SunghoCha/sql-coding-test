


import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());

        CircularDeck deck = new CircularDeck(size);
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int value = Integer.parseInt(st.nextToken());
                deck.pushFront(value);
            } else if (command == 2) {
                int value = Integer.parseInt(st.nextToken());
                deck.pushBack(value);
            } else if (command == 3) {
                int i1 = deck.popFront();
                sb.append(i1).append("\n");
            } else if (command == 4) {
                int i1 = deck.popBack();
                sb.append(i1).append("\n");
            } else if (command == 5) {
                int size1 = deck.size();
                sb.append(size1).append("\n");
            } else if (command == 6) {
                int empty = deck.empty();
                sb.append(empty).append("\n");
            } else if (command == 7) {
                int front = deck.front();
                sb.append(front).append("\n");
            } else if (command == 8) {
                int back = deck.back();
                sb.append(back).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }


    public static class CircularDeck {
        private int[] deck;
        private int capacity;
        private int size;
        private int front;
        private int rear;

        public CircularDeck(int capacity) {
            this.deck = new int[capacity];
            this.capacity = capacity;
            this.size = 0;
            this.front = 0;
            this.rear = 0;
        }

        // front는 값을 가지고 있고 rear는 추가될 위치
        public void pushFront(int value) {
            if (size == capacity) {
                throw new IllegalStateException("덱이 가득 참");
            }
            front = (front - 1 + capacity) % capacity;
            deck[front] = value;
            size++;
        }

        public void pushBack(int value) {
            if (size == capacity) {
                throw new IllegalStateException("덱이 가득 참");
            }
            deck[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
        }

        public int popFront() {
            if (size == 0) {
                return -1;
            }
            int value = deck[front];
            front = (front + 1) % capacity;
            size--;

            return value;
        }

        public int popBack() {
            if (size == 0) {
                return -1;
            }
            rear = (rear - 1 + capacity) % capacity;
            int value = deck[rear];
            size--;

            return value;
        }

        public int size() {
            return this.size;
        }

        public int empty() {
            return this.size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return deck[front];
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return deck[(rear - 1 + capacity) % capacity];
        }

    }

}


