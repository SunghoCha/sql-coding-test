import java.util.*;
class Solution {
    public static List<List<String>> userList = new ArrayList<>();
    public static Set<Set<String>> resultSet = new HashSet<>();
    public int solution(String[] userArr, String[] banArr) {
        
        /*
            주어진 불량사용자에서 가능한 경우의 수들을 다 곱한것이 모든 경우의 수
            사용자 배열 크기 8이하. 불량사용자는 사용자크기 이하
            각 원소의 크기도 8이하
            아이디중복없음. 소문자와 숫자로만 구성
            불량에서 *는 1개 이상
            완탐해도 상관없을듯?
            
            불량리스트 루프마다 유저목록돌면서 가능한 케이스를 카운팅해서 기록
            루프 다 끝나면 카운팅들을 다 곱하면 그것이 모든 경우의 수
            근데 이렇게 안풀릴수도있는듯?
            3번케이스보니... 한 아이디가 여러 불량케이스에 동시에 해당할수있음..
            그래서 단순히 루프에서 경우의수들을 곱할수없음..
            그러면 카운팅 곱이 불가능. 독립이 아닌 종속케이스
            불량리스트 루프돌떄 사용가능한 유저아이디목록이 제외되어야함
            이걸 주의하면서 불량-유저 매칭 메서드만 구현하면 됨
            근데 이게 쉽지않은데.. 여러 경우의 수를 구하는 문제인데 혹시 dfs방식으로 해야하나?
            이거 조합문제인가?
            우선 벤패턴에 해당하는 유저목록을 추림
            벤패턴 루프돌면서 유저아이디 매칭하면서 조합 구함
            
        */
        int n = userArr.length;
        userList = new ArrayList<>(); // 인덱스는 벤리스트와 연동
        for (int i = 0; i < banArr.length; i++) { // 초기화
            userList.add(new ArrayList<>());
        }
        for (int i = 0; i < banArr.length; i++) { // 벤리스트 루프
            String ban = banArr[i];
            for (int j = 0 ; j < n; j++) {
                if (matches(userArr[j], ban)) {
                    userList.get(i).add(userArr[j]);    
                }    
            }    
        }
        
        dfs(0, new HashSet<>());
        
        int answer = 0;
        return resultSet.size();
    }
    
    // depth는 벤리스트의 인덱스
    public void dfs(int depth, Set<String> set) {
        if (depth == userList.size()) {
            resultSet.add(new HashSet<>(set)); // 복사해서 넣기
            return;
        }   
        
        for (String user : userList.get(depth)) {
            if (set.contains(user)) {
                continue;
            }
            set.add(user);
            dfs(depth + 1, set);
            set.remove(user);
        }
    }
    
    /*
        문자열 같은 위치에서 값이 다르면 해당 banArr이 *이어야함
    */
    public boolean matches(String user, String ban) {
        char[] users = user.toCharArray();
        char[] bans = ban.toCharArray();
        for (int i = 0; i < users.length; i++) {
            if (users.length != bans.length) {
                return false;
            }
            if (users[i] != bans[i] && bans[i] != '*') {
                return false;
            }
        }
        return true;
    }

}