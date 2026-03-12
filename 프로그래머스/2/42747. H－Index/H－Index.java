import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        /*
            그냥 반복문으로 풀면 1000만.
            정렬한다음 해당 h(높이, 인용횟수) 이상인 것 카운팅하는데
            작은것부터하면 애매한듯? 역으로 큰 것부터 하는게 바로 컷되서 나을듯?
            이렇게하면 찾는순간 바로 그게 답아닌가?
            근데 이렇게하면 또 안되네..."이상"을 제대로 잡아내지 못함
            그냥 내인덱스 정보로 h알 수 있고 length - 내 인덱스로 개수 알 수 있음
            작은것부터 이렇게해도 1000만 순회하면 됨
            
            0 1,2,3   4
        */
        Arrays.sort(citations);
        int length = citations.length;
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i <= 10000; i++) {
            int count = 0;
            for (int ci : citations) {
                if (ci >= i) {
                    count++;
                }
            }
            if (count >= i) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}