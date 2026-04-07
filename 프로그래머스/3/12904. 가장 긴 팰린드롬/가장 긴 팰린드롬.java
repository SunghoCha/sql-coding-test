class Solution {
    public int solution(String s) {
        
        /*
            s의 부분문자열 중 가장 긴 팰린드롬
            대칭문자열. 짝수이거나 홀수 두 가지 케이스
            전체길이 2500이하
            양끝 대칭으로 체크불가능. 어디까지 대칭인지 알 수 없음
            어떻게 팰린드롬 체크가 가능하지?
            연속된 문자열이어야함
            홀수 : 해당문자열 기준으로 양옆 확장
            짝수 : 해당문자열과 다음 문자열 기준으로 양옆 확장
        */
        
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(max, findOdd(i, chars));
            max = Math.max(max, findEven(i, chars));
        }
        
        
       
        return max;
    }
    
    public int findOdd(int i, char[] chars) {
        int left = i - 1;
        int right = i + 1;
        int count = 1;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            count += 2;
            left--;
            right++;
        }
        return count;
    }
    
    // i왼쪽으로 할지 오른쪽으로 할지는 일관성만 있으면 될 듯?
    public int findEven (int i, char[] chars) { 
        int left = i;
        int right = i + 1;
        int count = 0;
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            count += 2;
            left--;
            right++;
        }
        return count;
    }
}