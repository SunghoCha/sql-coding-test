import java.util.*;
class Solution {
    int n = 0;
    int m = 0;
    int x = 0;
    int y = 0;
    int r = 0;
    int c = 0;
    int k = 0;
    // d l r u 하 좌 우 상
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    List<String> result = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;
        /*
            이동하는 거리가 총 k. 같은 격자 두번이상 방문 가능
            미로에서 탈출한 경로를 문자열로 나타냈을때 사전순으로 가장 빠른 경로
            l r u d
            격자크기 n, m
            출발위치 x, y
            탈출지점 r, c  이동거리 k
            탈출불가능 -> impossible 반환
            
            장애물도없고 방문중복없어서 탈출불가능은 바로판단가능해야할듯? 홀짝?
            abs(r - x) + abs(c -y)가 홀수일떄 k가 짝수 또는 반대이면 불가능
            
            nm크기의 2차원만들어야하나 아니면 그냥 가능?
        */
        int len = Math.abs(r - x) + Math.abs(c - y);
        if ((len % 2 == 0 && k % 2 != 0) || (len % 2 != 0 && k % 2 == 0) || k < len) {
            return "impossible";
        }
        
        map.put(0,"d");
        map.put(1,"l");
        map.put(2,"r");
        map.put(3,"u");
        
        int step = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            step++;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }
                if (getDist(nx, ny) > k - step) {
                    continue;
                }    
                x = nx;
                y = ny;
                String s = map.get(j);
                sb.append(s);
                break;
            }
            
        }
     
        return sb.toString();
    }
  
    public int getDist(int i, int j) {
        return Math.abs(i - r) + Math.abs(j - c);
    }
}