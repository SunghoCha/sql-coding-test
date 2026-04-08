class Solution {
    int m = 0;
    int n = 0;
    int l = 0;
    public boolean solution(int[][] key, int[][] lock) {
        
        /*
            자물쇠 크기 N * N, 열쇠 크기 M * M
            열쇠는 회전과 이동이 가능. 열쇠의 돌기가 자물쇠의 홈에 맞으면 열림
            자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠 여는데 영향없음
            자물쇠영역 내에서만 정확히 일치하면 됨
            열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됨
            자물쇠의 모든 홈을 채워 비어있는 곳이없어야 열림
            
            그러니까 자물쇠 영역 내의 홈과 졍확히 일치하도록 열쇠의 돌기 조정
            자물쇠 외 부위는 상관없음
            0은 홈 1은 돌기
            
            시간복잡도
            크기자체는 20 * 20으로 작아서 완탐도 가능하긴함
            회전은 결국 총 4가지 케이스를 의미
            이동은 자유...?
            일단 돌기인 1에 집중해야함
            열쇠돌기 1이 자물쇠의 홈 0에 맞게 신경쓰는게 최선
            필요없는 1은 버리고 회전을 해서 유효한 1을 홈에 맞춘다
            
            일단 회전을 먼저 적용해서 총 4가지 케이스로 분류
            그리고 최대 이동은 열쇠의 한 길이인 m - 1만큼 유효. m번 이동하면 사라짐
            그러면 이동개념을 어떻게 구현? 패딩을 둘까? 무슨패딩? 패딩은 헛소리같음
            이동한 모양도 경우의수로 만든다면? 총 몇가지정도일까?
            임의의 한 칸은 이동을 통해 m * m내에서 어디로든 이동가능..
            상하좌우 4가지 케이스에 대해 m - 1번 이동하는 케이스 -> 4 * (m - 1)
            총 16 * (m - 1) 케이스면 시간초과는 안날듯
            이 케이스를 만들고 매 케이스마다 맞는지 확인하기 위한 m^2?
            그러면 약 m^3정도? m은 20이니 이렇게해도 충분할듯?
            
            리뷰받음
            상하좌우가아니였음
            (n + m - 1) * (n + m - 1) 경우의 수?
            자물쇠에 패딩을 둬서 양옆에 m - 1씩 둠 -> n + 2 * (m - 1)로 하면 체크 편함
            결국 패딩영역은 값이 불일치할거고 이걸 무시해야함
            
            
        */
        n = lock.length;
        m = key.length;
        l = n + 2 * (m - 1);
        int[][] newLock = new int[l][l]; // 패딩
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[m - 1 + i][m - 1 + j] = lock[i][j];
            }
        }
        int[][] newKey = key;
        for (int i = 0; i < 4; i++) {
            newKey = rotate(newKey);
            for (int j = 0; j < l - m + 1; j++) {
                for (int k = 0; k < l - m + 1; k++) {
                    if (isCorrect(newKey, newLock, j, k)) {
                        return true;
                    }        
                }
            }
        }
        return false;

    }
    
    public int[][] rotate(int[][] key) {
        /*
            i,j -> j, (m-1) - i    
        */
        int[][] rotated = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][m - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }
    
    /*
        좌표보정을 한 후 유효한 범위내에서 전체가 일치하는지 체크
        애초에 패딩을 넣었는데 좌표보정이 필요한가?
        유효범위는?  0   m - 1이상   n + m - 2이하   n + 2(m - 1) - 1
    */
    public boolean isCorrect(int[][] key, int[][] lock, int x, int y) {
        int[][] tmp = new int[l][l];
        for (int i = 0; i < l; i++) {
            tmp[i] = lock[i].clone();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp[x + i][y + j] += key[i][j];
            }
        }
        
        for (int i = m - 1; i < m - 1 + n; i++) {
            for (int j = m - 1; j < m - 1 + n; j++) {
                if (tmp[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
        
    }
}