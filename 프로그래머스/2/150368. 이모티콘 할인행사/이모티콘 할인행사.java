import java.util.*;
class Solution {
    public static int[][] users;
    public static int[] emoticons;
    public static int[] discounts = new int[]{10, 20, 30 ,40};
    public static List<int[]> result = new ArrayList<>();
    public int[] solution(int[][] usersP, int[] emoticonsP) {
        users = usersP;
        emoticons = emoticonsP;
       
        /*
            가입자 최대한 늘리기 그다음 목표가 판매액 늘리기
            사용자들은 기준에 따라 이모티코을 사거나 서비스가입함
            사용자는 자신의 기준에 따라 일정비율 할인 이상 이모티콘 모두 구매
            그 후 이 비용이 일정가격 이상이 된다면 구매를 모두 취소하고 서비스에 가입
            
            이모티콘 할인율을 조정해서 서비스가입비율을 최대로하고 이게 같다면 판매액을 늘려야함
            
            유저 100명
            이모티콘은 100의 배수개수로 존재, 최대 100만개
            할인율의 함수라고 했을떄
            할일율 100개 * 유저 100명 * 이모티콘수 100만 하면 시간복잡도 초과할듯?
            혹시 할인율에 대한 부분 단조함수 형태인가?
            그러니까 이모티콘할인율의 특정 구간에 한해서 서비스가입자수가 동일하고 단조형태를 띄는가?
            아니면 특정 구간에서도 서비스가입자수가 경향성이 없나?
            할인율을 올리면 가입자수가 줄어드는 경향성이 맞는지도 다시봐야함
            왜냐하면 무조건 할인받아서 구매하는게 아니고 구매를 아예 안하거나 하게 되는것임
            즉, 할인율을 올리면 기존에 구매안하던것도 구매하게됨. 이러면 구매안했을떄 금액초과안해서
            서비스가입 안하다가 오히려 하게될수도있음.
            이러면 할인율 올렸을때 오히려 가입자수가 늘어날수도있으므로 단조경향성이 존재하지않음.
            즉, 이분탐색은 탈락...
            완탐, 이분탐색이 안된다는것... 그럼 뭘로하지?
            
            리뷰받음
            100만은 이모티콘의 가격.. 이모티콘 개수는 최대 7개..
            할인율도 10 20 30 40 으로 총 4개
            근데 완탐이라는게 단순한 3중 반복문이 아님
            특정 조합을 만들어내야함
            바뀌는 경우의 수는 이모티콘할인율에 대한것
            할인율의 모든 조합(이모티콘 수와 일치)에 대해 유저들마다 구매적용후
            판단해서 가입자수와 판매량 구함
            
            우선 할인율의 경우의 수. 이건 순열이어야함. 구하기
            emoticons배열과 할인율배열은 인덱스로 페어링
            모든 유저에 대해서 유저할인율 배열 루프돌면서 할인율 조건 만족하면
            이모티콘 금액*할인율한 금액 차감.
                이때 금액이 초과되면 서비스가입으로 전환하고 서비스가입자수 늘리고 break. 
                (해당 유저는 더이상 볼필요없음)
                루프 다돌면(초과 안되면) 총금액을 판매액에 저장
            근데 생각해보니 이 과정이 모든할인율 경우의 수에 대해서 이루어져야함
            그렇다면 dfs돌리다가 베이스조건 걸렸을때 이걸 수행하는 흐름?
                
            
        */
        // 할인율 순열 구하기. 10 20 30 40. 이모티콘 길이만큼
        List<Integer> list = new ArrayList<>();
        result = new ArrayList<>();
        dfs(list, 0);
        result.sort((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
            
        
        return result.get(0);
    }
    
    public void dfs(List<Integer> list, int depth) {
        if (depth == emoticons.length) { // 특정 할인 경우의 수 완성됨
            int[] target = calcul(list);  
            result.add(target);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            list.add(discounts[i]);
            dfs(list, depth + 1);
            list.remove(list.size() - 1);
        }
    }
    
    /*
        
        모든 유저에 대해서 유저할인율 배열 루프돌면서 할인율 조건 만족하면
        이모티콘 금액*할인율한 금액 차감.
        이때 금액이 초과되면 서비스가입으로 전환하고 서비스가입자수 늘리고 break. 
        (해당 유저는 더이상 볼필요없음)
        루프 다돌면(초과 안되면) 총금액을 판매액에 저장  
    */
    
    public int[] calcul(List<Integer> list) {
        int userCount = 0; // 서비스 가입자수
        int amount = 0; // 판매액
        
        for (int i = 0; i < users.length; i++) { // 유저들에 대한 루프
            int limitDiscount = users[i][0]; // 유저 제한 할인율
            int limitCash = users[i][1]; // 유저 금액
            int sum = limitCash;
            boolean isJoined = false;
            for (int j = 0; j < list.size(); j++) { // list는 emoticons와 인덱스페어링
                int emoPrice = emoticons[j];        
                int emoDiscount = list.get(j);
                if (emoDiscount >= limitDiscount) {
                    int price = emoPrice / 100 * (100 - emoDiscount);
 
                    sum -= price;                        
                    if (sum <= 0) {
                        userCount++; // 서비스가입
                        isJoined = true;
                        break; // 해당 유저는 더이상 볼 필요없음
                    }
                }
            }
            // 가입안한 사람의 경우 총판매액 갱신
            if (!isJoined) {
                amount += limitCash - sum;    
            }
        }
      
        return new int[]{userCount, amount};
    }
}