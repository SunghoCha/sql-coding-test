

import java.io.*;
import java.util.*;


public class Main {

    private static int N, M, S;
    private static int count = 1;
    private static StringBuilder sb;
    private static boolean[] visited;
    private static int[] visitedOrder;
    private static Node[] nodes;
    private static Deque<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        ///////////////////////////////////////////////////////////////////////////
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 1];
        // 노드 생성
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }
        // 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].addAdjNode(nodes[b]);
            nodes[b].addAdjNode(nodes[a]);
        }
        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            nodes[i].getAdjNodes().sort((a, b) -> a.getNumber() - b.getNumber());
        }

        visited = new boolean[N + 1];
        dfs(nodes[S]);

        ///////
        sb.append("\n");
        count = 1;
        visited = new boolean[N + 1];
        bfs();


        ///////////////////////////////////////////////////////////////////////////
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    private static void dfs(Node node) {
        int number = node.getNumber();
        if (!visited[number]) {
            visited[number] = true;
            sb.append(number).append(" ");
            List<Node> adjNodes = node.getAdjNodes();
            for (Node adjNode : adjNodes) {
                dfs(adjNode);
            }
        }
    }

    private static void bfs() {
        queue.addLast(nodes[S]);
        visited[S] = true;
        sb.append(nodes[S].getNumber()).append(" ");

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            List<Node> adjNodes = node.getAdjNodes();
            for (Node adjNode : adjNodes) {
                int number = adjNode.getNumber();
                if (!visited[number]) {
                    visited[number] = true;
                    sb.append(number).append(" ");
                    queue.addLast(adjNode);
                }
            }
        }
    }


    public static class Node {
        int number;
        List<Node> adjNodes = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void addAdjNode(Node node) {
            adjNodes.add(node);
        }

        public List<Node> getAdjNodes() {
            return adjNodes;
        }

        public int getNumber() {
            return number;
        }
    }






}
