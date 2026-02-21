class Solution {
    public String solution(int[] food) {
        String answer = "";
        int length = food.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            int num = food[i] / 2;
            for (int j = 0; j < num; j++) {
                sb.append(i);
            }
        }
        String leftStr = sb.toString();
        
        String rightStr = sb.reverse().toString();
        sb = new StringBuilder();
        return sb.append(leftStr).append("0").append(rightStr).toString();
    
        
    }
}