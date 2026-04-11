import java.util.*;
class Solution {
    int min = Integer.MAX_VALUE;
    int[] dist;
    int[] weak;
    int w = 0;
    public int solution(int n, int[] weakOld, int[] dist) {
        this.dist = dist;
        /*
            외벽 동그란모양 총둘레 n미터
            정북방향 0. 시계, 반시계 이동가능
            각 친구가 1시간동안 이동할 수 있는 거리 배열 dist
            최소한의 친구들을 투입해 취약지점 점검
            주기적으로 점검. 점검시가능을 1시간 제한? 1시간안에 해당 지점 도착해야한다는건가
            
            시간복잡도
            외벽길이n 200, weak배열개수15, 원소크기는 n-1이하
            dist배열개수8, 원소 100
            
            한명으로 여러군데 돌 수 있음. 근데 시작위치가 아무데나?
            그리고 정수도 아니고 4.5m는 뭐지 도대체? 해당위치에 도착이 아니고 초과해야하나? 반열린구간?
            원형이라 더 헷갈림. 일직선으로 못바꾸나?
            
            12를 더해서 바꾼다는 생각을 떠올리지 못했음
            그리고 기존 weak 시작지점을 바꾸면서 dist 순열을 적용해서 계산한다는 생각도 못했음
        */
        this.w = weakOld.length;
        int[] weak = new int[2 * w];
        this.weak = weak;
        for (int i = 0; i < w; i++) {
            weak[i] = weakOld[i];
        }
        for (int i = w; i < 2 * w; i++) {
            weak[i] = weakOld[i - w] + n;
        }
        for (int i = 0; i < w; i++) {
            boolean[] visited = new boolean[dist.length];
            dfs(i, i + w, visited, 0);
            
        }
        
       
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    /*
        weakIdx는 현재 dfs에서 커버해야하는 시작지점.
        현재허용된 dist로 거리를 늘리고 이것으로 어디까지 weak가 커버되는지 계산하고
        커버되지않은 weakIdx를 다음 dfs로 전달한다
    */
    public void dfs(int weakIdx, int end, boolean[] visited, int count) {
        if (weakIdx >= end) {
            min = Math.min(min, count);
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                int weakDist = weak[weakIdx];
                int distance = dist[i];
                // =도 포함. 커버된것임.
                int nextIdx = weakIdx;
                while (nextIdx < end && weak[nextIdx] <= weakDist + distance) { 
                    nextIdx++;
                }
                dfs(nextIdx, end, visited, count + 1);
                
                visited[i] = false;
            }
        }
    }
}