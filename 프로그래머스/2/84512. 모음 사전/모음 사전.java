class Solution {
    
    public int ans;
    public int count;
    public int solution(String word) {
        ans = 0;
        String str = "AEIOU";
        char[] chars = str.toCharArray();
        backtrack(chars, 0, "", word);
        return ans;
    }
    
    public void backtrack(char[] chars, int depth, String str, String target) {
        if (target.equals(str)) {
            ans = count;
        
        }
        if (depth == chars.length) {
            return;
        } 
        
        
        for (int i = 0; i < chars.length; i++) {
            count++;
            backtrack(chars, depth + 1, str + chars[i], target);
        }

    }
}