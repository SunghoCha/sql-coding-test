class Solution {
    public static int answer = 0;
    public int solution(int[] number) {
        // 주어진 수 중에서 3개의 수를 순서와 상관없이 더해서 0이 되는 갯수
        // 조합 문제? 백트래킹인가?
        // depth가 3이면 종료. 베이스조건
        // 가지치기 하려면 r도 필요? 
        // 방문배열
        int answer = 0;
        int r = 3;
        int[] picked = new int[r];
        return backtracking(0, r, 0,  number.length, picked, number);
        
       
    }
    
    public int backtracking(int depth, int r, int start,  int n, int[] picked, 
                            int[] number) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < r; i++) {
                sum += picked[i];
            }
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        
        }
        
        int count = 0;
        
        for (int i = start; i < n; i++) {
            picked[depth] = number[i];
            count += backtracking(depth + 1, r, i + 1, n, picked, number);
            
        }
        return count;
    }
}