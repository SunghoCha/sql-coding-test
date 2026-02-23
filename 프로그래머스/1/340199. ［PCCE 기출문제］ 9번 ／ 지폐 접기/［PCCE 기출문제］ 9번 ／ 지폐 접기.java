class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int maxB = Math.max(bill[0], bill[1]);
        int minB = Math.min(bill[0], bill[1]);
        int maxW = Math.max(wallet[0], wallet[1]);
        int minW = Math.min(wallet[0], wallet[1]);
        
        while (maxB > maxW | minB > minW) {
            int folded = maxB / 2;
            maxB = Math.max(folded, minB);
            minB = Math.min(folded, minB);
            answer++;
        }
        return answer;
    }
}