import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        /*
            비트가 다른 지점이 2개 이하이면서 가장 작은 수..
            비트연산?
            합집합 - 교집합하면 다른 비트의 개수가 나옴
            타겟보다 1큰 수부더 찾자마자 반환하면 그게 가장 작은 수           
            
            그냥 아이디어 외워서 푸는 문제
            짝수만 + 1
            홀수면 가장끝에서 0찾아서 1 올리고 해당 자리바로 오른쪽을 0으로 바꿈
            target보다 큰 수중 가장 작은수가 됨
            문제가 좋은건지는 모르겠음. 그냥 아이디어 암기식 문제
            
        */
        List<Long> list = new ArrayList<>();
        for (long num : numbers) {
            if (num % 2 == 0) {
                list.add(num + 1);        
            } else {
                /*
                    홀수일때는 짝수처럼 못함. 맨 뒤에 1올리면 앞자리수가 다 바뀔수있음
                    그래서 0을 1로 올리되 가장 작은값 영향만 있게 하려면 가장 오른쪽 0을 올려야함
                    주어진 수를 1과 &연산해서 0이 나오면 그게 가장 오른쪽의 0
                */
                long bit = 1L;
                while ((num & bit) != 0) {
                    bit = bit << 1;
                }
                num = num + bit - bit / 2;
                list.add(num);    
            }   
        }
        return list.stream()
            .mapToLong(Long::longValue)
            .toArray();
    }
}