import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        /*
            행간정렬 :col번째 컬럼 기준 오름차순, 타이면 첫번째 컬럼으로 내림차순
            정렬된 데이터에서 S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 i로 나눈 나머지들의 합
            r_b <= i <= r_e인 모든 S_i를 누적하여 bitwise XOR? "|"인가?
            
            행단위로 묶어야함. 행단위 리스트?
        */
        int m = data.length;
        int n = data[0].length;
        int r_b = row_begin - 1;
        int r_e = row_end - 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.get(i).add(data[i][j]);
            }
        }
        int targetCol = col - 1; // 0-base
        list = list.stream()
            .sorted((a, b) -> {
                if (a.get(targetCol).equals(b.get(targetCol))) {
                    return b.get(0) - a.get(0);
                }
                return a.get(targetCol) - b.get(targetCol);
            }).collect(Collectors.toList());
        List<Integer> modList = new ArrayList<>();
        for (int i = r_b; i <= r_e; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                s += list.get(i).get(j) % (i + 1);
            }
            modList.add(s);
        }
        int ans = modList.get(0);
        for (int i = 1; i < modList.size(); i++) {
            ans = ans ^ modList.get(i);
        }
         return ans;
    }
   
}