class Solution {
    public static int zeroCount;
    public static int oneCount;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int n = arr.length;
        /*
            재귀로 풀어야할듯?
            4개로 쪼개짐
            특정 조건 만족하면 거기서 zero or one count 리턴? 아니면 ++?
            이건 그냥 재귀? backtrack하고는 상관없는?
            
            재귀에서 매번 전달되어야할 인자는? 
            arr, 범위(n n/2 ..),
            근데 단순 n/2 이런식으로 전달하면 4분면 체크 안됨..
            시작인덱스와 끝나는인덱스로 전달
            근데 이것도 행과 열에서의 좌표가 각각.. 그냥 시작 지점과, 범위
            
            
            해야할 일 목록
            주어진 영역이 한 종류의 수인지 체크. 맞다면 count 바로 추가 후 리턴
            한 종류가 아니라면 4영역의 재귀 호출
            
            n? or n - 1?  /2 했을떄 뭐가 편할지
            0 1 2 3 -> n = 4 : n / 2하면 2, n-1/2 하면 1
            나눈 지점을 시작지점으로 바로쓰려면 n으로 넣어야. (0, n]
            
            
        */
        dfs(arr, 0, 0, n); // 반열린구간
        
        return new int[]{zeroCount, oneCount};
    }
    
    public void dfs(int[][] arr, int x, int y, int n) {
        if (isSameArea(arr, x, y, n)) {
            int num = arr[x][y];    
            addCount(num);
            return;
        }
        // 재귀. 좌표지정과 범위설정이 중요
        // 시작지점, 범위
        int range = n / 2;
        dfs(arr, x, y, range);
        dfs(arr, x + range, y, range);
        dfs(arr, x, y + range, range);
        dfs(arr, x + range, y +range, range);
    }
    
    public boolean isSameArea(int[][] arr, int x, int y, int n) {
        int target = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (target != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void addCount(int num) {
        if (num == 0) {
            zeroCount++;
        } else if (num == 1) {
            oneCount++;
        }
    }
}