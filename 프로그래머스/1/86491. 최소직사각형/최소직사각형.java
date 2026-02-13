class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int minMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < sizes.length; i++) {
            int subMax = Integer.MIN_VALUE;
            int subMin = Integer.MAX_VALUE;

            int x = sizes[i][0];
            int y = sizes[i][1];
            
            if (x > y) {
                subMax = x;    
                subMin = y;
            } else {
                subMax = y;
                subMin = x;
            }
            
            
            if (subMax >= max) {
                max = subMax;
            }
            if (subMin >= minMax) {
                minMax = subMin;
            }
        }
        return max * minMax;
    }
}