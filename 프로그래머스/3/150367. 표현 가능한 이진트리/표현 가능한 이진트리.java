import java.util.*;
class Solution {
    boolean isValid = true;
    public int[] solution(long[] numbers) {
        /*
           주어진 수를 이진수로 변환
           0은 더미노드 1은 노드
           (64) 32 (16) 8 (4) 2 (1)
           0101010 - 41 o
           01110 - 14 x
           111
           무조건 홀수개. 가운데가 루트로 1이어야하고..
           이진트리구성여부는 루트, 서브트리의 루트존재..
           짝수개면 맨앞에 0을 더해서 홀수개로 만들듯?
           이 상태에서 맨앞부터 보면서 자신의 부모가 있는지를 확인해야함
           이진트리이므로 부모확인하는 공식이 존재
           단순히 왼쪽부터 스캔하면서 확인은 불가.
           대칭성활용해야함
           010 1 010
           0 1 0 / 1 / 0 1 0
           가운데를 중심으로 나누면 각각이 서브트리가 된다.
           이거에 대해 확인하는거니 재귀같은데?
           맨처음 0101010를 전달하면 이것에 대해서 가운데를 기준으로 나눔 010 1 010
           그리고 양쪽 2개를 다시 전달
           dfs(0101010) -> dfs(010) dfs(010) -> ...
           
           0패딩개수알아보기
           41 : 32 (16) 8 (4) 2 (1)
           101010 ~ 2^5 . -> length 6
           length - 1 = k
           1 2 4 8 16 32... 이런 형태로 나눠야 포화이진트리 구성가능
           현재 주어진 개수 기준으로 최소한의 패딩을 더해서 만들면 된다.
           현재 주어진 개수는? length.
           (2^k - 1) - length 만큼의 0을 더하면 된다.
           int k = 0;
           while ( 2^k -1 < length) {
                k++;
           }
        */
        List<Integer> list = new ArrayList<>();
        for (long number : numbers) {
            String str = Long.toBinaryString(number);
            str = padding(str);    
            isValid = true;
            dfs(str);
            if(isValid) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public String padding(String str) {
        int n = str.length();
        int k = 0;
        while (Math.pow(2, k) - 1 < n) {
            k++;
        }
        int m = (int)Math.pow(2, k) - 1 - n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append("0");
        }
        return sb.append(str).toString();
    }
    /*
        ex) 길이 5 -> 5/2 -> 2 : 가운데 인덱스   
        0 1 2 3 4
        해당 트리에서의 루트가 0인지체크
        0이 아니면 ok
        0이라면 이 루트의 모든 자식들도 0이어야함
        
        
    */
    public boolean dfs(String str) {
        if (str.length() == 1) {
            if (str.equals("1")) { // 존재함
                return true;
            }
            return false;
        }
        int mid = str.length() / 2;
        String left = str.substring(0, mid); // mid 제외
        String right = str.substring(mid + 1); // 끝까지
        boolean hasLeft = dfs(left);
        boolean hasRight = dfs(right);
        if (str.charAt(mid) == '0') {
            if (hasLeft || hasRight) {
                isValid = false;
            }        
            return false;
        } else {
            return true;
        }
    }
}