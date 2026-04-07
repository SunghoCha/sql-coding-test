import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    String[] referrals;
    public int[] solution(String[] enrolls, String[] referrals, 
                          String[] sellers, int[] amounts) {
        this.referrals = referrals;
        
        /*
            직접판매가 아닌 자신에게 발생하는 이익 또한 마찬가지의 규칙으로 자신의 추천인에게 분배됨
            원 단위에서 절사. 10%가 1원 미만인 경우는 자기가 모두 가짐 (10원 미만)
            칫솔개당 판매수익은 100원 고정
            
            idx 매칭 관계
            enroll - 구성원 (민호 제외) ~ 1만
            referral = enroll에 있는 조직원을 참여시킨 사람의 이름 ~ 1만
            "-"면 추천인은 center? 근데 어차피 답은 enroll 기반이라 신경안써도 될 듯?
            
            idx 매칭 관계
            seller - 물건판매한 사람. 같은 이름 중복가능. ~ 10만
            amount - 판매개수
            
            판매원에게 배분된 이익금의 총합(정수형)을 enroll에 포함된 순서대로 나열
            
            seller 루프돌면서 재귀적으로 들어가나?
            잘못하면 재귀스택이 1만까지들어감.
            10만 * 1만... 불가능. 매번 재귀는 불가능
            
            일단 어차피 판매목록이 칫솔이고 다 100원이면 seller를 사람별로 압축?
            일단 단순하게 생각해보자. 시간초과나더라도?
            seller 목록돌면서 해당 이름으로 판매액 계산.
            referral을 찾아야하는데 String으로는 바로 접근 힘듦.
            Map<String, Integer> enrollMap으로 인덱스찾음
            이 인덱스로 referral[idx]로 추천인 찾고 10퍼할당. 그리고 여기서의 10퍼로 재귀적할당...
            근데 애초에 enrollmap으로해야하나 ? referralMap으로 하면 안되나? 똑같은거같은데
            근데 이렇게하면 "-"인 경우가 애매해짐.
            
            재귀로직의 정의는? dfs() : 처음 seller의 string을 dfs 인자로전달하면될듯?
            dfs(String name, int amount) : name에게 90퍼를 할당하고 추천인에게 10퍼를 할당한다?
        */
        
        for (int i = 0; i < enrolls.length; i++) { // 인덱스 매핑용
            map.put(enrolls[i], i);
        }
        int[] ans = new int[enrolls.length];
        for (int i = 0; i < sellers.length; i++) {
            String seller = sellers[i];
            int amountCount = amounts[i];
            int amount = 100 * amountCount;
            dfs(seller, amount, ans);
        }
        
        
        int[] answer = {};
        return ans;
    }
    
    public void dfs(String seller, int amount, int[] ans) {
        if (amount <= 0) {
            return;
        }   
        
        int enrollIdx = map.get(seller);
        int toReferral = amount / 10;
        if (toReferral <= 0) {
            ans[enrollIdx] += amount;    
            return;
        }
        ans[enrollIdx] += amount - toReferral;
        String refer = referrals[enrollIdx];
        if (refer.equals("-")) {
            return;
        }
        dfs(refer, amount / 10, ans);
        
    }
}