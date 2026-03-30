import java.util.*;
class Solution {
    public String[][] relation;
    public boolean[] visited;
    public Set<Integer> set = new HashSet<>();
    public Set<Set<Integer>> resultSet = new HashSet<>();
    public int m = 0;
    public int n = 0;
    public int count = 0;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        resultSet = new HashSet<>();
        count = 0;
        /*
            유일성, 최소성 만족시키는 조합찾아내기
            크기 1,2,3,... relation[0].length
            한 튜플에서 조합을 정하고 그 조합에 대해 전체 탐색하면서 유일성 체크
            최소성은? 조합이라는겐 인덱스의 조합임 예를 들어 0,1이 있으면 0,1,2는 안된다는것
            즉 내가 구한 조합 중 부분집합으로서 이미 유일성을 만족하는것이 있으면 안됨
            이걸 어떻게 체크하지? 내가 새로운 조합찾을떄마다 기존 조합하고 비교를?
            애초에 조합이 만들어질때 체크해야하나?
            
            조합으로 1,2,3.. 에 대해서 최소성체크를 먼저할것인지 유일성체크를 먼저할것인지?
            최소성체크 먼저하는게 효율이좋을듯? 그래서 이걸 어떻게?
            기존에 만족하는것들은 어떤 자료구조에 담겨있지?
            혹시 저장할떄 인덱스들을 정렬해놓고 string으로 저장한다음에 contain?
            contain의 시간복잡도는? 그냥 쓴다고치자.
            그리고 조합구할때 어차피 정렬된 상태의 인덱스 순서대로 쌓이지않나?
            
            str로하면 인데스가 두자리가 되는순간 꼬임. set으로 인덱스관리
            해시set의 containsAll로 최적화해서 조회
        */
        
        m = relation.length;
        n = relation[0].length;
        visited = new boolean[n];
        set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            bfs(0, i, set);
        }
        
        return resultSet.size();
    }
    
    /*
        
        0 ~ n - 1까지의 길이 1 ~ n-1까지가 모든 조합 경우의수가 된다.
        n은 불가능하므로 리턴? 베이스조건은? n이되면 베이스?
        특정길이가 아닌 모든 길이에 대한 조합으로 바뀌니까 제대로 못풀고있는 취약점
        첫 지점 0이라고해보자 0에 대해 수행하고 0, 1조합으로 넘어가는건가?
    */
    public void bfs(int start, int size, Set<Integer> set) {
        if (set.size() == size) { 
            if (isNew(set) && isUnique(set)) {
                resultSet.add(new HashSet<>(set));  // 복사본 넣어야함 매우 중요
            }       
        }
                
        for (int i = start; i < n; i++) {
            set.add(i);
            bfs(i + 1, size, set);            
            set.remove(i);
        } 
    }
    
    /*
        set에 인덱스에 해당하는 컬럼들을 다 합쳐서 하나로 만들어서 체크
        이걸 set<String>에 담아서 사이즈체크하는 아이디어를 떠올리지못함
    */
    public boolean isUnique(Set<Integer> set) {
        Set<String> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String str = "";
            for (int col : set) {
                str += relation[i][col] + ":"; // 구분자
            }
            colSet.add(str);
        }
        if (colSet.size() == m) {
            return true;
        }
        return false;
    }
    
 
    
    public boolean isNew(Set<Integer> set) {
        for (Set<Integer> result : resultSet) {
            if (set.containsAll(result)) {
                return false;
            }
        }
        return true;
    }
}