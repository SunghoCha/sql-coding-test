class Solution {
    public int[] solution(String[] wallpaper) {
        
        /*
            주어진 x,y 좌표중에서 가장 작은 x값 ~ 가장 큰 x값
            가장 작은 y ~ 가장 큰 y
            주어진 데이터는 스트링 배열이고 쉼표로 구분
            처음 등장하는 str이 가장 작은 x좌표
        */
        // idx 0 ~ 49
        int minX = 51; 
        int minY = 51;
        int maxX = -1;
        int maxY = -1;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];                
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (ch == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i + 1);
                    maxY = Math.max(maxY, j + 1);
                }
            }
        }
        int[] answer = new int[4];
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;
        return answer;
    }
}