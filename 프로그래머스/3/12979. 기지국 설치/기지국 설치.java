import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        
        /*
            아파트의 개수 n : 2억 -> 그냥 반복문도 힘든?
            스테이션은 1만, 오름차순 정렬되어 있음.
            주어진 w -> 2w + 1로 앞에서부터 채워야함
            스테이션 영역이 2w + 1의 배수구간에 정확히 맞으면 1개를 감소시켜주는 효과(최적)
            근데 다음 시작포인트는 2w+1의 배수구간 아님 시작점은 스테이션마다 갱신됨
            시작점은 맨처음은 0이고 그다음은 스테이션만날때마다의 end 다음점
            시작점부터 다음스테이션 시작바로 전 지점까지의 구간을 2w + 1로 나누고 올림처리하면 개수구해짐
            
            여기서 다시 시작점 갱신하고 반복.
            시작점 ~ 스테이지전 구간이 이미 커버되는지가 어떻게 체크되는지도 봐야함
            이게 음수로 나오면 스킵
            
            
        */
        int start = 1;
        int range = 2 * w + 1;
        int count = 0;
        // station은 일종의 인덱스지만 1-base. 근데 배열없이 하므로 1부터하는게 자연스러운듯
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            int startRange = station - w;
            int endRange = station + w;

            // if (startRange <= 0) { // 왼쪽이 이미 다 채워짐
            //     //////////////
            //     start = endRange + 1; // 채워지지않은 첫 지점
            //     if (start >= n) { // 오른쪽이 이미 다 채워짐 
            //         return count;
            //     }
            //     //////////////
            //     continue;
            // }
            int num = (int)Math.ceil(((double)(startRange - start) / range));
            if (num > 0) { // 음수이거나 0이면 겹쳐서 추가할 필요없고 무시하면 됨
                count += num;
            }
            //////////////
            // 다음 지점으로 갱신
            start = endRange + 1; // 채워지지않은 첫 지점
            if (start > n) { // 이미 다 채워짐 
                return count;
            }
            //////////////          
        }
        int ranged = n - start + 1;
        if (ranged > 0) {
            count += (int)Math.ceil((double)ranged / range);
        }
        return count;
    }
}