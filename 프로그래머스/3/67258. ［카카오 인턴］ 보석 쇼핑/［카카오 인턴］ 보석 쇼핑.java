import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        /*
            gems 를 set에 담아서 size부터 체크하고
            윈도우사이즈 내에 유효한 사이즈와 일치하는 경우 min길이인지 체크하는식으로?
            근데 사이즈가 작을수는 있어도 초과는 안되는듯?
            이렇게 해서 결국 만족시켰을떄 그제서야 left를 빼면서 개수 유지되는지 봐야하지않나?
        */
        Set<String> resultSet = new HashSet<>();
        for (String gem : gems) {
            resultSet.add(gem);
        }
        int total = resultSet.size();

        
        int[] ans = new int[2];
        int length = gems.length;
        int left = 0;
        int min = Integer.MAX_VALUE;
        boolean isSame = false;

        Map<String, Integer> map = new HashMap<>();
        for (int right = 0; right < length; right++) {
            String gem = gems[right]; 
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            
            
            while (map.size() == total) {
                isSame = true;
                String leftGem = gems[left];
                int count = map.get(leftGem);
                if (count == 1) {
                    map.remove(leftGem); // 이 로직으로 while문 탈출
                } else if (count > 1) {
                    map.put(leftGem, count - 1);
                }
                left++;
            }// 여길 빠져나오면 마지막 유효 left가 빠진상태인데?
            // 이 상태로 isSam필요없이그냥 바로 계산?
            
            if (isSame) {
                isSame = false;
                left--;
                int newLen = right - left + 1;
                if (newLen < min) {
                    ans[0] = left + 1;
                    ans[1] = right + 1;
                    min = newLen;
                }
                left++;
            }
        }
        return ans;
    }
}