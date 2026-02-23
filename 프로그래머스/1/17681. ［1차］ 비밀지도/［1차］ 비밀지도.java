class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = arr1[i];
            int b = arr2[i];
            int num = a | b;        
            String str = toBinaryStr(num);
         
            String format = "%" + n + "s";
            String result = String.format(format, str).replace(' ', '0');
            
            sb = new StringBuilder();
            for (char ch : result.toCharArray()) {
                if (ch == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
            
        return answer;
    }
    
    public static String toBinaryStr(int num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
        
        
    }
}