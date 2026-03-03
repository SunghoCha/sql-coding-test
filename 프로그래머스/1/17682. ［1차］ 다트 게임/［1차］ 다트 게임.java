import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        /*
            스택으로 푼다
            스택에는 계산결과 숫자만 넣어도됨
            *가 있으면 스택에서 하나꺼내서 *2하고 다시 넣고 그다음 자기 자신넣음
            루프끝나면 꺼내서 다 더함
            lifo
            queue.addLast(), queue.pollLast()
            push, pop
            
            숫자+문자+ 특수문자 or 숫자일듯
            근데 숫자단위 구별이 쉽지않음, 2자리 or 3자리라서 인덱스로 끊기 애매함
            숫자가 등장하는 순간 앞에있는걸 계산하는 흐름?
            스택과 별도로 버퍼가 있어야할거같은데?
            스택은 계산된 숫자 저장용?
            버퍼는 숫자계산하기전 요소들?
        */
        
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> buffer = new ArrayDeque<>();
        dartResult = dartResult.replace("10", "K");
        for (char ch : dartResult.toCharArray()) {
            // num, power 초기화
            int num = 0;
            int power = 0;
            if (Character.isDigit(ch) || ch == 'K') {
                num = (ch == 'K') ? 10 : ch - '0';
                // 앞에 쌓인 버퍼 계산해서 스택에 넣음
                if (!buffer.isEmpty()) {
                    int result = calculNumber(buffer); 
                    stack.push(result);
                    
                }
                // 자기자신은 clear된 버퍼에 넣음                
                buffer.offer(ch);
            } else if (Character.isLetter(ch)) {
                if (ch == 'S') {
                    power = 1;
                } else if (ch == 'D') {
                    power = 2;
                } else if (ch == 'T') {
                    power = 3;
                }
                buffer.offer(ch);
            } else { // 특수 문자. buffer에 넣기도하지만. 바로 앞 숫자하나꺼내서 갱신
                if (ch == '*') {
                    if (!stack.isEmpty())  {
                        int preNum = stack.pop();
                        preNum = 2 * preNum;
                        stack.push(preNum);
                    }
                    // 자기자신을 버퍼에 넣음
                    buffer.offer(ch);
                } else if (ch == '#') {
                    // 자기자신을 버퍼에 넣음
                    buffer.offer(ch);
                }
            }
             
        }
        if (!buffer.isEmpty()) {
            int result = calculNumber(buffer);
            stack.push(result);
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
    
    public static int calculNumber(Deque<Character> buffer) {
        if (buffer.isEmpty()) {
            return 0;
        }
        
        int num = 0;
        int power = 0;
        char first = buffer.poll();
        num = (first == 'K') ? 10 : Character.getNumericValue(first);

        char ch = buffer.poll() ;
        if (ch == 'D') {
            num = (int) Math.pow(num, 2);
        } else if (ch == 'T') {
            num = (int) Math.pow(num, 3);
        }
        
        if (!buffer.isEmpty()) {
            char ch2 = buffer.poll();
            if (ch2 == '#') {
                num = (-1) * num;
            } else if (ch2 == '*') {
                num = 2 * num;
            }
        }
        buffer.clear();
        return num;
            
        
    }
}