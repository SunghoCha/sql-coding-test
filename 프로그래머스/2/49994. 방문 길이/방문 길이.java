import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        /*
            처음 걸어본 길의 길이구하기. 방문배열로 체크해서 카운팅?
            길이 500이하 자연수
            근데 2차원에서 움직이긴하는데 배열정보가 주어진건 아님
            0 1 2 3 4 5 6 7 8 9 10
            0,0 ~ 10,10
        */
        
        int a = 0;
        int b = 0;
        Set<String> set = new HashSet<>();

        for (char ch : dirs.toCharArray()) {
            StringBuilder sb = new StringBuilder();
            int x = a;
            int y = b;
            if (ch == 'U') {
                x -= 1;
            } else if (ch == 'D') {
                x += 1;
            } else if (ch == 'L') {
                y -= 1;
            } else if (ch == 'R') {
                y += 1;
            } 
            if (x >= -5 && x <= 5 && y >= -5 && y <= 5) {
                String str = a + "," + b + "," + x + "," + y;
                String str2 = x + "," + y + "," + a + "," + b;
                set.add(str);
                set.add(str2);
                a = x;
                b = y;
            }

        }
            
        return set.size() / 2;
    }
}