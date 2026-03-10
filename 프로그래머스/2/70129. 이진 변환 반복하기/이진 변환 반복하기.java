class Solution {
    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        /*
            while 문 안에서 
            0제거한 개수 카운트
            0제거 후 길이를 이진수로 변환
            str 갱신 후 다시 while 반복. 언제까지? str에 0이 없을떄까지.
        */
        
        int zero = 0;
        int convert = 0;
        String str = s;
        while (!str.equals("1")) {
            int num = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zero++; // 제거된 0의 개수
                } else if (ch == '1') {
                    num++;
                }
            }  
            
            sb = new StringBuilder();
            while (num > 0) { // 남은 1의 길이를 2진법으로 변환
                sb.append(num % 2);
                num /= 2;
            }
            str = sb.reverse().toString();
            convert++;
            
        }  
        
        

        

        
        return new int[]{convert, zero};
    }
    

}