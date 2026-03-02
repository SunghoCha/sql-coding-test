import java.util.*;
class Solution {
    public static class File implements Comparable<File> {
        String head;
        int number;
        String original;
        
        File(String head, int number, String original) {
            this.head = head;
            this.number = number;
            this.original = original;
        }
        
        @Override
        public int compareTo(File other) {
            String thisHead = this.head.toUpperCase();
            String otherHead = other.head.toUpperCase();
            
            if (thisHead.equals(otherHead)) {
                return Integer.compare(this.number, other.number);
            }
            return thisHead.compareTo(otherHead);
        }
        
        
    }
    
    public String[] solution(String[] files) {
        
        /*
            프로그램의 과거 버전을 모두 담고 있음, 이름순으로 정렬되어 있음
            이름 순 정렬하면 10이 9보다 먼저 표기되는 문제
            숫자를 반영한 정렬 기능 구현
        */
        List<File> list = new ArrayList<>();
        for (String str : files) {
            char[] chars = str.toCharArray();

            int startNumberIdx = -1;
            int startTailIdx = -1;
            int limit = 5;
            for (int i = 0; i < chars.length; i++) {
                boolean isDigit = Character.isDigit(chars[i]);
                
                if (startNumberIdx == -1) {
                    if (isDigit) {
                        startNumberIdx = i;
                    }
                } else if (startTailIdx == -1) { // 길이가 5 초과이거나 숫자가 아니거나
                    if (!isDigit || i - startNumberIdx >= limit) {
                        startTailIdx = i;
                        break;
                    }
                }
                                               
            }
            String head = str.substring(0, startNumberIdx);
            String number = "";
            if (startTailIdx == -1) {
                  number = str.substring(startNumberIdx, str.length());       
            } else {
                 number = str.substring(startNumberIdx, startTailIdx);    
            }
            list.add(new File(head, Integer.valueOf(number), str));
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            File file = list.get(i);
            answer[i] = file.original;
        }
        
        return answer;
    }
}