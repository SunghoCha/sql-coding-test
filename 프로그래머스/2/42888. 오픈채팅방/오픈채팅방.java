import java.util.*;
class Solution {
    public String[] solution(String[] record) {
       
        
        /*
            record를 split하면 인덱스가 0,1,2 
            0으로 들어왔는지 나갔는지
            1은 id. 0에서 change로 체크
            2는 닉네임
            결국 최종닉네임이 중요.
            근데 맵에다가 계속 덮어쓰면 안되나? change 감별이 중요한가?
            전체 루프돌면서 id별 최종닉네임 정한 후에
            다시 루프 한번 더 돌면서 문자열 완성
        */
        String enterSurfix = "님이 들어왔습니다.";
        String leaveSurfix = "님이 나갔습니다.";
        String enter = "Enter";
        String leave = "Leave";
        Map<String, String> map = new HashMap<>();
        for (String str1 : record) {
            String[] str = str1.split(" ");
            if (!leave.equals(str[0])) {
                map.put(str[1], str[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for (String str1 : record) {
            String[] str = str1.split(" ");
            if (enter.equals(str[0])) {
                String str2 = map.get(str[1]) + enterSurfix;
                list.add(str2);
            } else if (leave.equals(str[0])) {
                String str2 = map.get(str[1]) + leaveSurfix;
                list.add(str2);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}