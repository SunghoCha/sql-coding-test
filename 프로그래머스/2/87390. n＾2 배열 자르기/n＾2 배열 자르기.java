class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        /*
            그냥 역순으로 큰수부터 채워나가면 2차원배열 완성될듯?
            그 상태에서 이어붙이는건데. 실제로 이어붙인다음에 잘라야할듯?
            근데 n이 너무 큼. n^2 시간복잡도 불가능
            그래서 역순으로 전체배열 채우는 n*n을 1 ~ n번하는건 불가능
            설마 수학적 규칙찾는건 아닐텐데...
            주어진 위치를 0base 기준으로 했을때,  (left row col 0부터 시작)
            left / n 하면 row가 나옴. left % n하면 col 나옴
            left, right로 2차원 배열내의 위치는 찾았음
            그러면 거기에 할당된 값은?
            0,0 -> 1        
            1,1 -> 2 / 0,1 1,0
            2,2 -> 3 / 2,1 ..    
            해당 col row의 max값 기준으로 값이 정해짐.
            max값 +1 
            left , right의 좌표까지 반복문 돌면서 "해당 좌표로 변환후"에 "값을 구해서" 추가한다
        
        */
        int length = (int) (right - left + 1);
        int[] ans = new int[length];
        int idx = 0;
        for (long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            ans[idx] = (int) Math.max(row, col) + 1;
            idx++;
        }

                    
        
        return ans;
    }
}