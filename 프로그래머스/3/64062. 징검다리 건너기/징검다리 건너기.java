class Solution {
    public int[] stones;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        /*
            디딤돌은 한 번 밞을때마다 숫자 1 줄어듦
            0되면 못 밞고 바로 그 다음 디딤돌로 한번에 점프가능
            한 명이 징검다리를 모두 건넌 후에 다음 사람이 건너기 시작 (이게 중요한가? 굳이 설명?)
            한 번에 건너뛸 수 있는 최대 칸 수 k
            디딤돌 개수는 20만, 디딤돌 숫자는 최대 2억
            사람은 무제한?
            완탐 아예 불가능
            결국 최대 k칸 점프를 사용해도 도달할 수 없는 구간이 생기기전까지 건넌 최대사람수
            k개의 0이 연속된 구간이 생기면 끝인데..
            이 구간이 최대한 늦게생기도록?
            뛰는 패턴은 마구잡이로 다양한데 이걸 어떤식을 해야?
            예를 들어서 최대한 많이 밞으면서 뛰는것부터 순서대로하면 이게 최종결과에 영향을 미치나?
            최대한 적게 밟으면서 뛰게하면 이게 최종결과에 영향을 미치나?
            안 미칠거같은데?
            애초에 문제자체가 k번 내에서자유롭게뛰는게 아니고 0이나오면 그제서야 k번 내에서 점프하는거임
            그러면 20만짜리를 매번 계속 순회? 사람은 무제한이고 숫자는 최대 2억인데?
            이건 불가능..
            그렇다고 정렬하면 순서자체가 틀어져서 안됨..
            결국 n명이 건너게 되면 모든 디딤돌숫자에서 n을뺌
            근데 이걸막 할 수 있는건 아님 
            n을 뺐을떄 0 이하인 연속 구간이 k보다 큰 구간이 존재하는가?
            canCross(x) 함수는 최대몇번건널수있는지에 대한 함수
            x를 인자로 받았을때 주어진배열에서 0이하 구간의 길이가 k이상인지 체크
            x가작을떈 true.. 어느순간 false로 바뀌는 지점.
            내가 찾는건 true일떄 가장 큰 x.
            이분탐색.  
            일반적인 이분탐색은?
            mid에서의 값이 원하는 값보다 크거나 같은
        */
        int lo = 0;
        int hi =  200000000;
        while (lo < hi) { // 최대값찾기
            int mid = (hi + lo + 1) / 2;
            if (canCross(mid, k)) { // 현재 지점은
                lo = mid;           
            } else {
                hi = mid - 1;
            }
        }
            
        int answer = 0;
        return lo;
    }
    
    /*
        stones에서 모든 원소에서 mid값을 빼면서 0이하이면 카운팅누적
        카운팅이 k이상이면 false반환
        0이하가 아니면 카운팅 초기화
        
    
    */
    public boolean canCross(int mid, int k) {
        int count = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }   
        }
        return true;
    }
}