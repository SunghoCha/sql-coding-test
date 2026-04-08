import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        
        /*
            주어진 결과 바탕으로 정확하게 순위를 매길 수 있는 선수의 수를 반환
            순위를 정확하게 매길 수 있다는 것은 무슨 뜻? 어떻게 정의?
            적어도 한 선수는 모든 선수와 경기를 했어야하나?
            그건 아님. 자기와 경기를 했던 선수와 경기했던 기록이 있으면 되는데 
            이게 단순히 승패와 상관없나?
            예를 들어서 1번이 2,3번 이김. 1번이 우위. 근데 4번도 이김.
            이러면 불가능. -> 간접적으로 연결되어있을땐 승패 중요.
            그래프로 나타낼때 이 승패개념은 방향성으로 해야할듯?
            확실한 우위가 있다고 했으니 단방향 그래프임
            4,3 이면 4 -> 3이고 4번이 3번을 이김.
            자기가 이길수있는 상태로 전이가능.
            결국 특정선수가 모든 그래프와 연결되어 있을때만 순위를 맺을수있음
            문제 예시를 보면 1,3,4가 2번으로 연결. 2번은 5번으로 연결
            근데 이러면 다 연결되는데.. 그렇다고 모든 순위가 드러나는건아님
            다시 디테일하게 생각해보자.
            일단 순위 정해지는 확실한 케이스
             모든 노드와 연결된 노드
             순위확정된 노드와 연결된 노드
            만약 모든 노드와 연결된 노드가 하나도없다면 순서를 정할수없는지부터 체크
            2가 1,3,4에 대해 승리, 5가 1,3,4 중 하나로 패배.
            결국 직접 다 연결아니더라도 그냥 다 탐색가능한 노드가 존재하면 순위정해짐
            그리고 이 노드에 대해서.. 승이나 패에 따라 달라지나?
            
            순위를 확정하는것에 대한 정의를 제대로 내리지 못하고 있음
            처음엔 해당 노드에서 다른 노드로 다 연결되면 가능한줄알았는데 이것도 아님
            
            리뷰받음
            순위를 확정한다는건
            나보다 확실히 강한 사람 + 나보다 확실히 약한 사람 = n - 1이 되어야함
            결국 모든 상대와 나의 승패여부를 알아야지만 순위가 결정됨
            그래프탐색으로 하자니 단방향이라 내가 이기는 사람으로의 탐색만 가능
            이걸 생각을 바꿔서 방향을 바꾼 패배용 그래프도 별도로 만드는것이 주요 아이디어
            노드별로 이 두개의 그래프를 탐색해서 n - 1이 되야지만 순위가 확실히 정해진다는것
             
        */
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            win.get(winner).add(loser);
            lose.get(loser).add(winner);
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int winCount = bfs(win, i, n);
            int loseCount = bfs(lose, i, n);
            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public int bfs(List<List<Integer>> adj, int num, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(num);
        visited[num] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }                
            }
        }
        return count;
    }
}