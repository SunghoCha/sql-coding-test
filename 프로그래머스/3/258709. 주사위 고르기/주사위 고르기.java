import java.util.*;
class Solution {
    int n = 0;
    int[][] dice;
    int max = Integer.MIN_VALUE;
    List<Integer> result = new ArrayList<>();
    public int[] solution(int[][] dice) {
        this.dice = dice;        
        
        /*
            주사위를 n/2개씩 선택하여 a집합, b집합으로 나뉨
            이때의 모든 발생한 경우의 수에 대해 a의 "승점을 계산"
            승점계산 방식이 알고리즘을 결정하는 핵심 요소 중 하나
            승점계산은 발생가능한 특정 경우. a와 b주사위 집합을 각각 던져서 나온 수들의 "합" 비교
            이 때 필요한 정보는 "합".
            그리고 a를 던지는데 그때마다 b의 모든 경우의 수에 대해 매번 탐색해서 완탐해야하는지?
            이건 a의 특정 결과가 b의 결과에 영향을 줄때만 종속됨
            하지만 이 경우는 독립이므로 a와 결과와 상관없이 b의 모든 경우의 수에 대해서
            나온 수들의 "합"정보를 미리 정리하여 사용가능.
            
            여기서 다시 한 번 직관에 대한 점검 필요
            맨처음 시도 
            1. 막연하게 이중반복문처럼 a의 모든 하나하나의 케이스들에 대해서 b를 완탐하는것을 떠올림
            2. 그다음 a와 b가 독립이기 때문에 b의 정보를 "합"정보로 다룸
            지금의 사고는 a의 모든 발생한 경우이 수들에 대해 b의 정보만 가공한것
            이건 마치 a를 주체로 삼고 b를 대상으로 하여 매번탐색하는것..
            여기서 해야할 질문은 "던져진 주사위 수들의 합"이라는 관점에서 a의 모든 가지수가 분리되어서
            다뤄질 필요가 있는가?
            a와 b는 대칭적이고 누가 주체고 누가 대상인 그런것과 상관없음. 즉,
            3. a도 b와 같은 관점에서 정보가공이 가능하다.
            가공은 countA[i], countB[i] : i는 던져진 주사위들의 합을 의미하고 
            값은 그 합을 가지는 던져진 주사위들의 경우의 수를 의미한다
            그렇다면 이 정보로 최종적으로 도출해야하는 것은?
            a가 자신이 승릴 확률이 가장 높아지도록 주사위를 가져가는것.
            이는 다시 말해 승리 카운팅이 높으면 된다는것
            다시 의미를 점검해보면 countA[]는 주사위집합이 정해졌을때 얻을 수 있는 합별 카운팅 정보
            ** 주의 *8
            일단 여기서 countA[]와 countB[]를 가지고 로직을 작성하려는 순간
            내 무의식속에 혼란이 있음을 느낌. 아직 정리되지않은 상태의 사고방식을 나열하자면 다음과 같음
            일단 사고과정파악을 위해 누적합 없이 진행
            countA[i]은 countB[0] ~ count[i - 1]의 합을 대상으로 승리 가능
            이런식으로 모든 i에 대해 계산한다는게 뭘 의미하지?
            countA[]의 모든 카운팅들의 합은 결국 주사위들을 던져서 나오는 모든 경우의 수를 의미한다.
            애초에 내가 구해야하는건 a주사위집합 던져서 발생가능한 모든 경우의 수와 
            b주사위집합 던져서 발생가능한 모든 경우의 수를 곱해서 생기는 모든 가능한 경우의 수들에 대한
            승리카운팅 개수. 
            그런데 countA[i]가 이미 countB[0] ~ count[i - 1]의 합을 계산하였는데
            countA[i + 1]은 countB[0] ~ count[i]로 되면서 뭔가 중복이 발생하는 것처럼 위화감을 느낌
            
            사실 이는 중복이 아니고 countA[]의 단 1개의 카운트가 countB[]의 모든 카운트개수 7776개에
            대해 작용하는것이므로 중복이아닌 별도의 세계선이여서 결국 7776 * 7776인것을
            효율적으로 계산하는것인데 이걸 제대로 못받아들이고 있는것인가?
            
        
        */
        
        n = dice.length; // 주사위 개수
        List<Integer> aList = new ArrayList<>();
        dfsDice(0, 0, aList);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i) + 1; // 1-base로 변환
        }
        return answer;
    }
    // 순서상관없는 조합
    
    public void dfsDice(int start, int depth, List<Integer> aList) {
        if (depth == (n / 2)) { // 주사위배열 다 선택됨
            List<Integer> bList = new ArrayList<>();             
            for (int i = 0; i < n; i++) {
                if (aList.contains(i)) continue;
                bList.add(i);
            }
            int newMax = evaluate(aList, bList);
            if (newMax > max) {
                max = newMax;
                result = new ArrayList<>(aList);
            }
            return;
        }
        
        for (int i = start; i < n; i++) {
            aList.add(i);
            dfsDice(i + 1, depth + 1, aList);    
            aList.remove(aList.size() - 1);
        }
        
    }
    
    /*
        countB를 기반으로 prefixSum. 
        prefixSum : i 미만까지의 개수
    */
    public int evaluate(List<Integer> aList, List<Integer> bList) {
        int[] countA = calculateCount(aList);
        int[] countB = calculateCount(bList);
        int[] prefixB = new int[countB.length + 1];
        for (int i = 1; i <= countB.length; i++) {
            prefixB[i] = prefixB[i - 1] + countB[i - 1];
        }
        // 승수 계산
        int win = 0;
        for (int i = 0 ; i < countA.length; i++) {
            win += countA[i] * prefixB[i];
        }
        return win;
            
    }
    
    public int[] calculateCount(List<Integer> list) {
        /*
            list.size() = n/2
            list의 원소는 주사위의 인덱스를 의미
            n/2 개의 주사위에서 1 ~ 6번째 중 어떤 것이 선택되는지에 대한 순열을 위한 dfs
            
        */
        int maxSize = list.size() * 100;
        int[] count = new int[maxSize + 1];
        
        List<Integer> comb = new ArrayList<>();
        dfs(0, comb, list, count);
        return count;
        
    }
    
    public void dfs(int depth, List<Integer> comb, List<Integer> list, int[] count) {
        /* 
            이 dfs는 정해진 주사위조합 list에 대해서 주사위각각에서 하나씩 선택된 comb를 만듦
            이걸로 주사위 루프 안에서 comb루프돌면서 누적합 구함
            
            list는 주사위 인덱스
            6개의 중복가능한 수 구함 = comb(i) ~ list.get(i)로 매칭
            list.get(i)로 주사위 선택
            comb(i)로 그 주사위의 숫자 선택
            누적
            
        */     
        if (depth == list.size()) { // n/2개 주사위만큼
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                int[] diceArr = dice[list.get(i)];  // 주사위집합에서 하나 꺼냄
                sum += diceArr[comb.get(i)];    
                
            }
            count[sum]++;
            return;
        }
        
        for (int i = 0; i < 6; i++) {        
            comb.add(i);
            dfs(depth + 1, comb, list, count);    
            comb.remove(comb.size() - 1);            
        }
        
    }
}