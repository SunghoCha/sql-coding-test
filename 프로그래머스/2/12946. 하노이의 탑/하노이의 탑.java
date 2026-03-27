import java.util.*;
class Solution {
    public int[][] solution(int n) {
        
        /*
            2개의 기둥으로는 불가능
            보조기둥이 항상 필요
            그런데 이 보조기둥은 3개 중 하나로 고정된것이 아니고
            턴마다 역할이 바뀜.
            3개가 돌아가면서 바뀌나? 아니면 2개가 번갈아가면서?
            어느 기둥에서든 작은원판이 큰원판 위에 있어야함
            분기점 세우는게 중요해보이는데. 규칙을 찾아야함
            재귀적으로할거같긴한데..
            짝수 : 12 시작
            홀수 : 13 시작
            
            재귀로하면서 인자 순서를 바꿔서 전달하는 재귀였던거 같은데 이게 무슨원리인지 기억이 안남
            
            개수 출발 보조 목표
            n start sub main
        */
        List<int[]> list = new ArrayList<>();
        hanoi(n, 1, 2, 3, list); // n개를 1에서 3으로 옮긴다
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                answer[i][j] = list.get(i)[j];
            }
        }
        return answer;
    }
    
    // n = 1이면 start -> main 가게끔?
    // hanoi메서드가 하는건 뭐지?
    /*
        n개의 원판을 main으로 옮긴다?
        sub ,main은 매번 바꿔서 전달?
        그러면 옮기는 방법은 어떻게 추가하지?
        hanoi n =1일때부터 채워지나?
        hanoi는 반환값이 없나?
        그리고 행동이 2가지라고 해야하나 한가지인가?
        2가지라고치면 서브원판들 옮기고 나머지 큰걸 옮기는건데 뭔가 애매함
    */
    public void hanoi(int n, int start, int sub, int main, List<int[]> list) {
        if (n == 1) {
            list.add(new int[]{start, main});
            return;
        }
        
        hanoi(n - 1, start, main, sub, list); // n - 1개를 start에서 sub으로 옮긴다.
        list.add(new int[]{start, main}); // 로직이 이게맞나?
        hanoi(n - 1, sub, start, main, list);
    }
}