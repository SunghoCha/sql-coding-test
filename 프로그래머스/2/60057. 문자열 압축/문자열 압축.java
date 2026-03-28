class Solution {
    public int solution(String s) {
        /*
            문자열 길이가 1000이면 그냥 완탐으로 해도 될듯
            근데 배치사이즈로해서 하는게맞나? 예를들면
            abcbc 면 a2bc 아닌가? 근데 문자열은 제일 앞부터 잘라야만하는듯?
            그러면 배치사이즈가능하지않나?
        */
        char[] chars = s.toCharArray();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) { // batchSize
            int batchSize = i;
            StringBuilder totalSb = new StringBuilder();
            String target = "";
            int count = 0;
            for (int j = 0; j < s.length(); j += batchSize) {
                int end = Math.min(j + batchSize, s.length()); // [,) 라서 s.length까지
   
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < end; k++) {
                    sb.append(chars[k]);                      
                }
                String curStr = sb.toString();
                if (curStr.equals(target)) {
                    count++;
                } else {
                    if (count != 1 && count != 0) {
                        totalSb.append(count).append(target);       
                    } else {
                        totalSb.append(target);
                    }            
                    count = 1;
                    target = curStr;
                }                   
            }
            // 마지막 배치사이즈 처리
            if (count != 1) {
                totalSb.append(count).append(target);       
            } else {
                totalSb.append(target);
            } 
            String reuslt = totalSb.toString();
            min = Math.min(min, reuslt.length());
        }
        
        return min;
       
    }
}