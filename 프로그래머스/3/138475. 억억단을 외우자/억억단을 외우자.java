class Solution {
    int e = 0;
    public int[] solution(int e, int[] starts) {
        this.e = e;
        /*
            적당한 수 e를 알려주고 e 이하의 임의의 수 s를 여러개 알려줌
            각 s에 대해서 s 이상 e이하 중 억억단에서 가장 많이 등장한 수를 답해야함
            가장 많이 등장한 수가 여러개라면 그 중 가장 작은 수
            1<= <=8
            e는 500만, s의 길이 10만
            시간복잡도가 너무 커서 완탐불가. 수학적계산으로 접근해야하는건가?
            일단 완탐으로 생각하고 규칙, 제약을 찾아서 최적화
            억억단에서 각 숫자가 등장하는 횟수에는 규칙이 있음
            이를 찾아내는 함수는 어떤 규칙이 있는지 어떤 알고리즘을 활용해서 풀 수 있는지?
            억억단은 1억 * 1억짜리 행렬. 여기서 특정 수의 등장횟수를 카운팅
            대각선을 기준으로 대칭이긴한데 이걸 활용하려나?
            그냥 에라토스체를 활용한 약수 구하기 문제
            s ~ e까지가 10만개 주어지는데 중복됨
            s_min ~ e까지의 약수개수를 한번씩 구해놓으면 O(1)로 가능
            1 ~ e
            count로 0,1 ~ e까지 
        */
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j +=i) {
                count[j]++;    
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int[] suffixMax = new int[e + 1]; // i ~ e구간에서 가장 많이 등장한 횟수의 숫자
        for (int i = e; i >= 1; i--) {
            if (max <= count[i]) {
                suffixMax[i] = i;
                maxIdx = i;
                max = count[i];    
            } else {
                suffixMax[i] = maxIdx;
            }
        }
        
        int[] ans = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            ans[i] = suffixMax[starts[i]];
        }
        return ans;
    }
    

}