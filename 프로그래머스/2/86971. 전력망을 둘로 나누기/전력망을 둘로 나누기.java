import java.util.*;
class Solution {

    public static Map <Integer, List<Integer>> map = new HashMap<>();
    public static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        map = new HashMap<>();
        
        /*
            인접행렬도 되긴하겠지만 더 보편적인 인접리스트로 하자
            인접리스트의 형식은?
            map에 담던가? Map<Integer, List<Integer>> 이건가?
            
        */
        

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            map.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
        }
        
        boolean[] visited = new boolean[n + 1];        
        dfs(1, visited, n);
        return answer;
    }
    
    public int dfs(int node, boolean[] visited, int n) {
        visited[node] = true;
        List<Integer> nodes = map.get(node);
        int curSize = 1;
        
        for (int next : nodes) {
            if (!visited[next]) {
                int childSize = dfs(next, visited, n);
                int diff = Math.abs(n - childSize - childSize);
                answer = Math.min(diff, answer);
                curSize += childSize;

            }
            
        }
        return curSize;
    }
}