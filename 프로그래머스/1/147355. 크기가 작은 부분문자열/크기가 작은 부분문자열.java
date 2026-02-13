class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = t.length();
        
        for (int i = 0; i <= length - p.length(); i++) {
            String str = t.substring(i, i + p.length());
            Long target = Long.parseLong(str);
            Long longP = Long.parseLong(p);
            if (target <= longP) {
                answer++;        
            }
        }
        return answer;
    }
}