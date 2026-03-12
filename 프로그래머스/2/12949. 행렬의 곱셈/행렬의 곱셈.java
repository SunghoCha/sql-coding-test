class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        /*
            행렬곱 구하기
            앞의 행과 뒤의 열을 고정한 상태로 루프.
            3중루프(앞의 행, 뒤의 열, 앞의 열 ~ 뒤의 행루프하면서 더함)
        */
        
        for (int i = 0; i < arr1.length; i++) { // 앞 row
            for (int j = 0; j < arr2[0].length; j++) { // 뒤 col
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}