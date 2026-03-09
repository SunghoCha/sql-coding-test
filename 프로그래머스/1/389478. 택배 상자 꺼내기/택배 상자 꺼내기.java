class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        /*
            내 층에 속한 w배수 구할수있음 : ((num  - 1)/ w + 1) -> (8 - 1) / 6 + 1 ) = 2
            내 층 바로 위에 있는 숫자와의 합은 내 바로 위층수 * w + 1
            2 * ((num  - 1)/ w + 1) * w + 1 -> 내 윗층과 내 숫자의 합
            int up = 2 * ((num  - 1)/ w + 1) * w + 1  - num 
            up <= n 이라면 ++; 그리고 내 윗층 숫자로 num = up갱신
        
        */
        int number = num;
        while (number <= n) {
            int up = 2 * ((number  - 1)/ w + 1) * w + 1 - number;
            if (up <= n) {
                answer++;
            }
            number = up;
        }
        
        return answer;
    }
}