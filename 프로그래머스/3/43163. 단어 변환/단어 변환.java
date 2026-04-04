import java.util.*;
class Solution {
    
    public List<Node> nodes = new ArrayList<>();
    public int solution(String begin, String target, String[] words) {
        /*
            한번에 한 개의 단어만 바꿀수있음
            words에 있는 단어로만 변환할 수 있음
            이건 기존 단어들에서 한글자만 다른것들이 인접해있다는것이므로
            우선 words를 돌면서 한글자 다른것들을 완탐으로 찾아서 인접리스트 만든후에
            bfs돌면 될 듯
            
            노드가 단순 번호라면 인덱스 자체로 노드를 식별하여 사용할수있지만
            이 경우는 스트링이라 Node 객체만들어서 사용
            Node가 내부에 자신의 인접노드 리스트를 가지고 있는 형태
        */
        // word마다 adj 세팅
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node curNode = new Node(i, word, 0);
            nodes.add(curNode); // 노드리스트에 추가
        }
        for (Node node : nodes) { // 시간복잡도 n^2이긴한데 50 * 50.
            setAdjNode(node);
        }
        Node beginNode = new Node(words.length, begin, 0);
        setAdjNode(beginNode);

        return bfs(beginNode, target);
        

    }
    
    public int bfs(Node beginNode, String target) {
        boolean[] visited = new boolean[nodes.size() + 1]; 
        Deque<Node> queue = new ArrayDeque<>();
        int count = 0;

        System.out.println(beginNode.name);
        queue.offer(beginNode);
        visited[beginNode.num] = true;        
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            for (Node next : cur.adj) {
                if (!visited[next.num]) {
                    next.dist = cur.dist + 1;
                    if (next.name.equals(target)) {
                        return next.dist;
                    }
                    visited[next.num] = true;
                    queue.offer(next);
                }
            }
        }
        return 0;
    }
    
    /*
        다른 글자가 1개여야함
        Set<Character>으로 하고 set.size구하고 contain 돌았을떄 size - 1개여야함
        이렇게하면 순서다른 글자를 체크못함. 그냥 반복문돌면서 같은지 체크하다가
        다른게 2개 카운팅되면 탈락
    */
    public void setAdjNode(Node targetNode) {
        // 자기 자신을 set에 세팅
        String target = targetNode.name;
        
        for (Node node : nodes) {
            if (node.name.equals(target)) { // 자기자신 스킵
                continue;
            }
            if (isAdj(target, node.name)) {
                targetNode.adj.add(node);
            }
        }
    }
    
    public boolean isAdj(String target, String node) {
        int length = target.length();
        int missMatchCount = 0;
        for (int i = 0; i < length; i++) {
            if (target.charAt(i) !=  node.charAt(i)) {
                missMatchCount++;
                if (missMatchCount > 1) {
                    return false;
                }
            }
        }
        return missMatchCount == 1;
    }
    
    public static class Node {
        public int num;
        public String name;
        public int dist;
        public List<Node> adj = new ArrayList<>();
        
        Node (int num, String name, int dist) {
            this.num = num;
            this.name = name;
            this.dist = dist;
        } 
    }
}