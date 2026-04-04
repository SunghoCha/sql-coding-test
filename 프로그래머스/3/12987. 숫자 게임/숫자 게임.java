import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        /*
            주어진 a배열에 대해 b배열의 각 원소들을 적절히 할당해서 최대점수
            a의 각 점수에 대해 간신히 이길수있으면 좋음
            a와 b를 매칭하는 문제이므로 a의 순서에 집착할 필요가없음 필요하면 정렬도 가능
            아니면 우선순위큐?
            근데 둘 다 가장 큰수끼리 매칭하면? 안됨. 지는게 확실하면 적은걸로 매칭해야 손해최소
            그러면 그냥 b의 가장큰수를 a의 내림차순정렬을 루프돌면서 자기가 이길수 있는 수가 나올떄마다
            매칭시는식으로 하면 최선 아닐까? 스킵하는건 알아서 그냥 제일작은것부터 배열하면됨
            이러면 n^인데 되는지 체크. 10만 * 10만이라서 안됨
            그러면 그냥 a랑 b를 각각 우선순위큐에 넣고 b보다 작은수가 나오면 그제서야 b에서 poll
            하는식으로하고 poll할때마다 +1점?
        */
        PriorityQueue<Integer> priA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> priB = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            priA.offer(A[i]); // a, b 길이같음
            priB.offer(B[i]);
        }
        int count = 0;
        while (!priA.isEmpty() && !priB.isEmpty()) {
            if (priA.poll() >= priB.peek()) {
                continue;
            } else {
                priB.poll();
                count++;
            }   
        }
        int answer = -1;
        return count;
    }
}