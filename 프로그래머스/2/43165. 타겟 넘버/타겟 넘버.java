class Solution {
    public int ans;
    public int solution(int[] numbers, int target) {
        ans = 0;
        
        dfs(numbers, target, 0, 0);
        return ans;
    }
    
    public void dfs(int[] numbers, int target, int depth, int num) {
        if (depth == numbers.length) { 
            if (num == target) {
                ans++;
            }
            return;
        }
        
        dfs(numbers, target, depth + 1, num - numbers[depth]);
        dfs(numbers, target, depth + 1, num + numbers[depth]);
    }
}