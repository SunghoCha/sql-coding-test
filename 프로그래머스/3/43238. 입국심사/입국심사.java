class Solution {
    public long solution(int n, int[] times) {
        
        /*
            모든 사람이 심사를 받는데 걸리는 시간의 최솟값
            사람수 10억, 심사시간 10억분, 심사관 수 10만
            시뮬레이션 방식이 말이 안됨. times에 있는 배수마다 카운팅 불가
            
            시간T가 주어졌을때 그 시간동안 몇명 처리가능한가?
            주어진 시간 T에 대해서 T를 time으로 나눈 몫들의 합
            이 함수는 T에 따른 단조증가함수 -> 이분탐색
            f(T) = n을 만족하는 최소T를 구하기
            
            이분탐색에서 단조증가함수에서 최소를 구하려면..
            왼쪽으로 좁혀야함. 즉 target과 같거나 크면 hi = mid 갱신
            mid는 답 후보이므로 hi를 갱신할때 mid를 포함해서 갱신
            lo쪽은 target보다 작은경우 갱신하며 답후보가 될 일이 없음
            lo = mid + 1로 갱신
            mid는 (lo + hi) / 2로 갱신할 경우. lo쪽이 mid가 되는데
            결국 lo는 +1이 되므로 무한루프에 갇히지않음
            
        */
        long lo = 1;
        long hi = 1000000000L * 1000000000L;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (getCount(mid, times) >= n) {
                hi = mid;    
            } else {
                lo = mid + 1;
            }
        }
        
        long answer = 0;
        return lo;
    }
    
    public long getCount(long t, int[] times) {
        long sum = 0;
        for (int time : times) {
            sum += t / time;
        }
        return sum;
    }
}