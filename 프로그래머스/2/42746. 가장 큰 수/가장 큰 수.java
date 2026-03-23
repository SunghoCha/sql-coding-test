import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        /*
            길이 10만이라 완탐하면 10만^2 이라 불가능
            원소중 "0"도 있음에 주의. "0"은 가장 뒤에 놓는게 무조건인듯
            일단 "모든" 수가 조합에 들어가야 가장 큰 수의 조건이 됨
            근데 원소 자체가 크다고해서 제일 앞에 놓을순없음
            예를들어 1000이라고해서 제일 앞에두면 "9"를 앞에둔것보다 작음
            즉, 원소의 자리수는 상관없음
            "값 자체"가 중요하다
            
            배열을 스캔하면서 그 순간 결정할 수 없음. 배열 마지막에 유일한 9가 있는 케이스
            그렇다고 이게 무조건 마지막까지 스캔한 후에 해야함을 말하나?
            그리디로 못푸나? 매순간 판단해서 가능할거같은데?
            자리수가 다른 경우 체크하는 로직만 잘 신경쓰면?
            비교시에 한자리수씩 쪼개서 해야함
            그러면 int -> String -> Character -> int로?
            
            비교로직은? 예를 들어 3, 30 ,34가 있을때
            3하고 비교해서 30은 3==3 이니 다음에서 3 >0외 되어서 오른쪽으로 판단됨.
            34는 3==3 다음에서 3 < 4로 모든 수가 3 이상이여서 왼쪽.
            근데 이 판단의 기준이 되는 숫자가 한자리수 아닌 경우는?
            근데 중간에 넣어야하는 케이스면?
            30 9 5 3 34라고치자
            5930 ? 안됨... 그냥 말이 안되는 방식...
            그라디하게 하는건 불가.
            그렇다면 결국 다 스캔하면서 어떤 자료구조에 담아서 활용하나?
            
            지금하려던건 대소비교를 새롭게 정의하고 매순간 비교하여 순서를 정한다로 요약할 수 있음
            그런데 그렇게 그라디하게 하는게 실패함
            
        */
        StringBuilder sb = new StringBuilder();

        String str = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> {
                return (b + a).compareTo(a + b);                 
            }).collect(Collectors.joining());
        
        if (str.charAt(0) == '0') {
            str = "0";
        }
        return str;

        
                
                
        

    }
}