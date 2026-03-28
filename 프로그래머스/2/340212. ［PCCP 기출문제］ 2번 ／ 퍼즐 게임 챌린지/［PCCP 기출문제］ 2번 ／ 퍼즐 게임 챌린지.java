class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        /*
            diffs[0] = 1
            시간복잡도 1 ≤ diffs의 길이 = times의 길이 = n ≤ 300000
            calcul은 30만
            while이 몇 번이나 돌지 추산가능? 잘 모르겠음
            그냥 calcul을 최적화하는것같음
            일단 diffs , times는 pair이고 순서가 고정. 이전순서 필요.
            예를 들어 level이 높아서 calcul의 if분기만 탄다고해보자
            그러면 그냥 times의 값 전체를 더하는것
            이 합을 구하려면 무조건 30만해야함 사실 이건 O(N)이라 당연
            else분기를 타더라도 어차피 똑같은 O(N)인데?
            어디서 최적화를?
            
            리뷰힌트
            힌트: level이 올라가면 총 시간은 어떻게 변하나요? 단조 감소하죠. 그러면 "조건을 만족하는 최소               level"을 찾는 건 어떤 탐색으로 바꿀 수 있을까요
            
            이분탐색해야하는거같음
            레벨은 결국 diff의 최대값까지만 의미있으니 최대 10만
        */
        
        // level때문에 메서드화해야하는데 일단 진행하고 메서드분리
        int lo = 1;
        int hi = 100000;
        while (lo < hi) {      
            int mid = (lo + hi) / 2;
            long time = calcul(diffs, times, mid);
            if (time <= limit) {
                hi = mid;     
            } else {
                lo = mid + 1;
            }            
        }
        return hi;
        
        
    }
    
    public long calcul(int[] diffs, int[] times, int level) {
        long time = 0; 
        for (int i = 0; i < diffs.length; i++) {
            int time_cur = times[i];
            int n = diffs[i] - level; // n번 틀려야함
            if (n <= 0) {
                time += time_cur;
            } else {
                // 여기로 오려면 무조건 i는 0초과
                time += (time_cur + times[i - 1]) * n + time_cur;                    
            }
        }
        return time;
    }
}