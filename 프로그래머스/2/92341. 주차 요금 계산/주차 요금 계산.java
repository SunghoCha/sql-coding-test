import java.util.*;
class Solution {
    private static String END_TIME = "23:59";
    public int[] solution(int[] fees, String[] records) {
       
        /*
            기본시간 기본요금 단위시간 단위요금
            시각 차량번호 내역
            
            입차면 스택에 넣고 출차를 만나면 isEmpty로 체크해서 계산
            근데 이렇게 하려면 차량번호별로 스택이라 말이 안됨.
            그러면 맵으로 <차량번호, 시각>으로해서 입차만 넣는건?
            입차 꺼내면 맵에서 삭제.
            그리고 마지막에 map에 값이 남아 있다면 출차가 없다는것. 23:59로해서 마무리계산
            그리고 차량번호별로 금액 정렬해야하는데?
            이것도 별도 map에 담아서 정렬하면 될 듯?
            
            계산시 주의할것
            시간은 분으로 환산하기
            기본시간 체크하기. 시간차계산시 "올림"할 것 double, ceil
            
            
        */
       
        Map<Integer, Integer> map = new HashMap<>();  // 차량번호, 시간 기록
        Map<Integer, Integer> timeMap = new TreeMap<>();  // 차량번호, 총시간
        Map<Integer, Integer> result = new TreeMap<>(); // 차량번호, 총비용
        for (String record : records) {
            String[] split = record.split(" ");    
            int time = convertTime(split[0]);
            int carNum = Integer.parseInt(split[1]);
            String inout = split[2];
            
            if (inout.equals("IN")) { // 같은 이름으로는 항상 1개만 있어야함
                map.put(carNum, time);
            } else {
                int inTime =  map.get(carNum);
                map.remove(carNum); // 출차했으면 입차 기록 삭제
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + time - inTime);
            }
        }
        // 출차 안한 것들도 시간에 포함
        if (map.size() != 0) {
            for (Integer carNum : map.keySet()) {
                int inTime = map.get(carNum);
                int time = convertTime(END_TIME);
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + time - inTime);
            }
        }
        // timeMap에 다 담김. 루프돌면서 비용계산하고 배열로 반환
        int[] ans = new int[timeMap.size()];
        int idx = 0;
        for (Integer carNum : timeMap.keySet()) {
            int totalCost = calcul(timeMap.get(carNum), fees);
            ans[idx++] = totalCost;
        }

        return ans;
        
    }
    
    int convertTime(String str) {
        String[] split = str.split(":");
        int hh = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        
        return 60 * hh + mm;
    }
    int calcul(int diff, int[] fees) {
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
       
        System.out.println(diff);
        if (diff <= defaultTime) {
            return defaultCost;
        } else {
            return defaultCost + 
                (int)Math.ceil(((double)diff - defaultTime) / unitTime) * unitCost;
        }
    }
}