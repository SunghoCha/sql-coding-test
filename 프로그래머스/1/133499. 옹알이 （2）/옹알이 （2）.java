class Solution {
    
    public static class Node {
        Node[] children = new Node[26];
        int wordId = 0;
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        Node root = new Node();
        String[] words = {"aya", "ye", "woo", "ma"};
        int num = 1;
        for (String str : words) {
            insert(root, str, num);
            num++;
        }
        for (String str : babbling) {
            if (canReach(root, str)) {
                answer++;
            }    
        }
        return answer;
    }
    
    public static void insert(Node root, String str, int num) {
        Node current = root;
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                current.children[idx] = new Node();
            }
            current = current.children[idx];
        }
        current.wordId = num;
    }
    
    public static boolean canReach(Node root, String str) {
        Node current = root;    
        int lastWordId = -1;
        for (char ch : str.toCharArray()) { 
            int idx = ch - 'a';
            if (current.children[idx] == null) {
                return false;
            } else if (current.children[idx].wordId != 0) {
                if (lastWordId == current.children[idx].wordId) {
                    return false;
                }
                lastWordId = current.children[idx].wordId;
                current = root;
            } else {
                current = current.children[idx];
            }
        }
        return current == root;
    }
    
    
}