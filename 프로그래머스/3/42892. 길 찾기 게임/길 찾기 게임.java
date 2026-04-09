import java.util.*;
class Solution {
    int n = 0;
    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {
        this.n = nodeinfo.length;
        /*
            서로다른 x값. 같은y값은 같은 레벨. y값 클수록 부모
            임의의노드v의 왼쪽 서브트리에 있는 모든 노드의 x값은 v의 x값보다 작다.
            임의의노드v의 오른쪽 서브트리에 있는 모든 노드의 x값은 v의 x값보다 크다
        */
        // 번호 보존하면서 정렬용 배열 생성
        int[][] nodes = new int[n][3];
        for (int i = 0; i < n; i++) {
            nodes[i] = new int[]{nodeinfo[i][0], nodeinfo[i][1], i + 1}; // 노드번호는 1번부터
        }
        // y 내림차순 정렬
        Arrays.sort(nodes, (a, b) -> {
            return b[1] - a[1]; // y값 내림차순
        });
        
        
        Node root = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);
        for (int i = 1; i < n; i++) {
            insert(root, new Node(nodes[i][0], nodes[i][1], nodes[i][2]));    
        }
        
        preOrder(root);
        postOrder(root);
        
        int[] preArr = new int[n];
        for (int i = 0; i < n; i++) {
            preArr[i] = pre.get(i);
        }
        int[] postArr = new int[n];
        for (int i = 0; i < n; i++) {
            postArr[i] = post.get(i);
        }
        
        int[][] answer = new int[2][n];
        answer[0] = preArr;
        answer[1] = postArr;
        return answer;
    }
    
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        pre.add(node.num);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        post.add(node.num);
    }
    
    public void insert(Node parent, Node child) {
        
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    public class Node {
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;

        }
        
            
        
    }
}