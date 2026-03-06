class Solution {
    public int solution(String s) {
        
        char[] chars = s.toCharArray();
        char first = ' ';
        boolean hasFirst = false;
        int firstCount = 0;
        int otherCount = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!hasFirst) { // 처음인경우
                hasFirst = true;
                first = ch;
                firstCount++;
                continue;
            }
            
            if (ch == first) { // 처음 아닌경우 카운팅
                firstCount++;
            } else {
                otherCount++;
            }
            
            if (otherCount == firstCount) { // 카운팅 후 비교
                    hasFirst = false; // 같으면 처음값 초기화
                    ans++; // 값 카운팅 증가
            }
            
        }
        if (hasFirst) { // 남은값 카운팅
            ans++;
        }
        return ans;
    }
}