import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        /*
            무적권 : 병사소모없이 한라운드 막음. 최대 k번
            언제 사용하는게 최적인지 알아야함
            병사수는 처음에 정해짐
            그러면 그냥 적 가장많을때 쓰면? 그러면 한번도 못쓰고끝날수도있음
            그래서 우선순위큐에 적수를 담는건 안됨
            적의 배열을 바꾸면 안될듯?
            그렇다고 그라디인가?
            
        */
        if (enemy.length <= k) {
            return enemy.length;
        }
        
        PriorityQueue<Integer> pri = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            n -= e;
            pri.offer(e);
            if (n < 0) { // n == 0이면 막은것
                if (k > 0) { // 근데 이거 복원해도 못막을수도있나? 막음. 이게 크면 맥스힙 가장 위.
                    int before = pri.poll();
                    n += before;
                    k--;
                } else {
                    return i; // i + 1이 라운드임 i + 1번쨰 라운드 못막았으니 i까지 막은것
                }
            } 
        }
  
        return enemy.length;
    }
}