import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        /*
            moves의 num은 board[i][num]을 의미
            0이 아닌 숫자를 처음 만날때까지 반복해서 만나면 그 숫자를 보드에서 0으로 바꾸고
            스택에 담기 전에 비어있지않으면 peek해서 같은게있으면 pop. answer++;
            아니라면 스택에 push.
            
        */
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < moves.length; i++) {
            int num = moves[i] - 1; // 인덱스로 보정
            for (int j = 0; j < board.length; j++) {
                if (board[j][num] == 0) {
                    continue;
                }
                int number = board[j][num];
                board[j][num] = 0;
                if (!stack.isEmpty() && stack.peek() == number) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(number);
                }
                break;
            }
        }
        
        return answer;
    }
}