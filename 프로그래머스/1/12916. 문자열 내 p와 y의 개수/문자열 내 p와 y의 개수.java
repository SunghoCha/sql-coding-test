class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int countP = 0;
        int countY = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = str.charAt(i);
            if (c == 'p') {
                countP++;
            } else if (c == 'y') {
                countY++;
            }
        }


        return countP == countY;
    }
}