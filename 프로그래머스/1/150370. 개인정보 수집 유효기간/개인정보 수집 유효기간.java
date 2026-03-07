import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] strs = term.split(" ");
            map.put(strs[0], Integer.parseInt(strs[1]));
        } // 약관 정보 맵
        
        String[] todays = today.split("\\.");
        int todayY = Integer.parseInt(todays[0]);
        int todayM = Integer.parseInt(todays[1]);
        int todayD = Integer.parseInt(todays[2]);
        
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] strs = privacy.split(" ");
            
            String pri = strs[1];
            int period = map.get(pri);
            
            String dates = strs[0];
            String[] date = dates.split("\\.");
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);
            // m이 12 초과해서 y 올라가는지만 체크. d는 굳이 체크안하고 계산 가능할듯
            int newMonth = m + period;
            if (newMonth >= 13) {
                y += (newMonth - 1) / 12;
                m = (newMonth - 1) % 12 + 1;
                if (todayY > y) {
                    list.add(i + 1);   
                } else if (todayY == y && todayM > m) {
                    list.add(i + 1);
                } else if (todayY == y && todayM == m && todayD >= d) {
                    list.add(i + 1);
                }
                
            } else {
                m = newMonth;
                if (todayY > y) {
                    list.add(i + 1);   
                } else if (todayY == y && todayM > m) {
                    list.add(i + 1);
                } else if (todayY == y && todayM == m && todayD >= d) {
                    list.add(i + 1);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    

}