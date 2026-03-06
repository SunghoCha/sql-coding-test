class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        /*
            그라디방식이라는걸 캐치하지못했음
            경계조건에서 그냥 앞뒤로 패딩을 주지않아서 경게조건분기가 늘어남
            항상 패딩으로 해결가능한지 체크해보기
            n+2 배열만들고 현재 개수반영하기
            반영하는 방법은?
            기본은 0인 상태니까 1로 만들고 reserve하면서 +1, lost하면서 -1
            
        */
        
        int[] list = new int[n + 2];
        for (int i = 1; i <= n; i++) { // 0 ~ n+1의 인덱스에서 양 끝 제외. 인덱스가 학생번호
            list[i] = 1;
        }
        for (int i = 0; i < lost.length; i++) { // 인덱스는 순회용
            int num = lost[i]; // 학생번호
            list[num]--;
        }
        for (int i = 0; i < reserve.length; i++) { // 인덱스는 순회용
            int num = reserve[i]; // 학생번호
            list[num]++;
        }
        // list 완성. 현재 학생이 가지고 있는 체육복 수를 의미
        // 그라디로 앞에서부터 빌리는 로직 수행
        for (int i = 1; i <= n; i++) { // 0 or 1 or 2인 상태
            int cur = list[i];
            int front = list[i - 1];
            int back = list[i + 1];
            if (cur == 0) { // 없으면 앞에서부터 빌림
                if (front == 2) { // 2일때만 빌릴 수 있음
                    list[i]++;
                    list[i - 1]--;
                } else if (back == 2) {
                    list[i]++;
                    list[i + 1]--;
                }
            } 
        }
        // list 순회하면서 1이상 찾음, 1 or 2
        for (int i = 1; i <= n; i++) {
            if (list[i] >= 1) {
                answer++;
            }
        }
        return answer;
        
         
    }
  
}