import java.util.*;
class Solution {
    int n = 0;
    boolean[][] garo;
    boolean[][] sero;
    
    public int[][] solution(int n, int[][] frames) {
    this.n = n; 
    garo = new boolean[n + 1][n + 1];
    sero = new boolean[n + 1][n + 1];    
        /*
            기둥은 바닥위 / 보의 한쪽끝 위 / 다른 기둥 위
            보는 한쪽 끝 부분이 기둥 위 / 양쪽 끝 부분이 다른 보와 연결
            기둥은 좌표, 보는 좌표사이? 
            좌표가 행렬과 다름. 수학좌표계
            작업을 수행한 결과가 조건을 만족하지않는 다면 해당 작업 무시
            
            벽면의크기 n*n / 프레임길이 1000  => 완탐가능
            x y a b / x,y는 기둥, 보 설치좌표. 
            a는 설치할 구조물 종류/ 0기둥 1보
            b는 구조물 설치할지 삭제할지/ 0삭제 1설치
            벽면벗어나는경우없음 / 바닥에 보 설치안함
            [x,y,a]의 배열. x좌표 기준 오름차순. 타이일경우 y좌표 오름차순
            x,y모두 같으면 기둥 우선
            
        */
        /*
            주어진 프레임대로 설치하되 조건을 만족하는지 체크해야함
            ==설치시 유효성==
            기둥이라면  (바닥위 / 보의 한쪽끝 위 / 다른 기둥 위)
             바닥위 : y좌표 0,  (y == 0) 
             보의 한쪽끝 위 : 내좌표를 시작 또는 끝으로하는 보 (x-1 y), (x, y)
             다른 기둥 위 : 내좌표x와 같고 y좌표 1작은 좌표 (x, y - 1)
            보라면 (한쪽 끝 부분이 기둥 위 / 양쪽 끝 부분이 다른 보와 연결)
             한쪽끝 기둥 위 : (x, y-1), (x+1, y-1)
             양쪽 끝부분이 보 : (x-1, y) && (x+1, y)
             
            ==삭제시 유효성==
            결국 나와 연결된 것들의 유효성을 검증하면됨.
            그냥 유효성검사하는 메서드만들고 사용. 생성,삭제시 하나의 메서드로 가능?
            기둥,보를 유효성검사 한번에 가능할듯
            생성,삭제는 하나로 합칠수있는지? 따로해야함
            생성은 하나의 포인트기준. 삭제는 나와 연결된 2포인트 기준.
             
            그리고 이미 주어진 배열은 어디에 저장해서 찾아올것인지?
            [x,y,a]로 저장해놓을까? 애초에 반환하는 답과 같은형태로?
            
            리뷰받음
            기둥과 보를 별도의 2차원 boolean[][]에 저장해놓고 O(1)로 판단
        */
        

        for (int[] frame : frames) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];
            // 저장하기전 유효성 체크
            if (b == 1) { // 생성
                if (canCreated(x, y, a)) {
                    if (a == 0) { // 기둥
                        sero[x][y] = true;
                    } else {
                        garo[x][y] = true;
                    }
                }
            } else { // 삭제
                delete(x, y, a);
            }            
        }   
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (garo[i][j]) {
                    list.add(new int[]{i, j, 1});
                }
                if (sero[i][j]) {
                    list.add(new int[] {i, j, 0});
                }
            }
        }
        /*
            [x,y,a]의 배열. x좌표 기준 오름차순. 타이일경우 y좌표 오름차순
            x,y모두 같으면 기둥 우선
        */
        list.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2]; // 기둥이 0. 오름차순
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
            
        
        int[][] answer = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    /*
     기둥이라면  (바닥위 / 보의 한쪽끝 위 / 다른 기둥 위)
     바닥위 : y좌표 0,  (y == 0) 
     보의 한쪽끝 위 : 내좌표를 시작 또는 끝으로하는 보 (x-1 y), (x, y)
     다른 기둥 위 : 내좌표x와 같고 y좌표 1작은 좌표 (x, y - 1)
     
     보라면 (한쪽 끝 부분이 기둥 위 / 양쪽 끝 부분이 다른 보와 연결)
     한쪽끝 기둥 위 : (x, y-1), (x+1, y-1)
     양쪽 끝부분이 보 : (x-1, y) && (x+1, y)
    */
    
    public boolean canCreated(int x, int y, int a) {
        
        if (a == 0) { // 기둥
            if (y == 0 || (x > 0 && garo[x - 1][y]) || garo[x][y] || sero[x][y - 1]) {
                return true;
            }    
        } else { // 보 : y >= 1, x+1 <= n
            if (sero[x][y - 1] // 보는 y = 1부터
                || sero[x + 1][y - 1] 
                || ((x > 0 && garo[x - 1][y]) && garo[x + 1][y])) { // x+1 <= n 
                return true;
            }
        }
        return false;
    }
    
    public boolean delete(int x, int y, int a) {
        if (a == 0) { // 기둥
            sero[x][y] = false;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (sero[i][j] && !canCreated(i, j, 0)) {
                        sero[x][y] = true;
                        return false;
                    }
                    if (garo[i][j] && !canCreated(i, j, 1)) {
                        sero[x][y] = true;
                        return false;
                    }
                }
            }
        } else {
            garo[x][y] = false;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (sero[i][j] && !canCreated(i, j, 0)) {
                        garo[x][y] = true;
                        return false;
                    }
                    if (garo[i][j] && !canCreated(i, j, 1)) {
                        garo[x][y] = true;
                        return false;
                    }    
                }
            }
        } 
        return true;
    }

}