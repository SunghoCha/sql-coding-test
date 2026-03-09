class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        /*
            시각을 분초를 따로 다루려고하지말고 합해서 다룰것
            커맨드에 따른 +-10을 일단 더하고나서 경계조건 체크해서 시간 정함
            포맷팅해서 반환
            마지막으로 이동한다고 끝나는게 아니고 여기서 prev가능한듯?
        */
        
        int lenT = calculate(video_len);
        int startT = calculate(op_start);
        int endT = calculate(op_end);
        int video_lenT = calculate(video_len);
       
        int posT = calculate(pos); // 시간변환
        if (startT <= posT && posT < endT) { 
            posT = endT;
        }
        for (String command : commands) {               
           
             
            // 시간 더하기
            int num = (command.equals("next")) ? 10 : -10;
            posT += num;
            
            // 범위 벗어나는지 체크해서 보정
            if (posT < 0) {
                posT = 0;
            } else if (posT > video_lenT) {
                posT = video_lenT;
            }     
            
            if (startT <= posT && posT < endT) { 
                posT = endT;
            }
        }
        return convert(posT);
    }
    
    public static int calculate(String str) {
        String[] splitStr = str.split(":");
        int strM = Integer.parseInt(splitStr[0]);
        int strS = Integer.parseInt(splitStr[1]);
        return strM * 60 + strS;
    }
    
    public static String convert(int num) { // 포맷도 살리도록해서 재활용성 높일까?
        int intM = num / 60;
        int intS = num % 60;
        return String.format("%02d:%02d", intM, intS);
    }
}