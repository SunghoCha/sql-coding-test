import java.util.*;
class Solution {
    public static String TARGET = "ICN";
    public String[][] tickets;
    public List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        /*
            tickets 기반으로 그래프 구성한다음에 알파벳빠른순으로 탐색하면될듯?
            그래프를 어떻게 구성할 것인지? String 자체를 노드로?
            List<List<String>> 으로하면 될듯?
            시작점은 tickets[0][0].
        */
        /* 
            바로 초기화는 어려울듯? 10000개 이하니까 10000개할수도있지만 ..
            근데 이렇게하면 애매한게 인덱스가 노드가 아니고 String이 노드가됨..
            Map<String, List<String>> 으로 해야하지않나?
        */
        //List<List<String>> adj = new ArrayList<>();

        this.tickets = tickets;
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        boolean[] used = new boolean[tickets.length];
        if (dfs(0, TARGET, used)) {
            String[] answer = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
        return new String[0];
    }
    // 한 번 방문하면 못했었나? 방문가능.. 방문하면서 전부 담음. 알파벳순
    // 그러면 지금처럼 adj 구성해도 되는게맞나?
    // 방문배열없이 그냥 하면 되려나..
    // 근데 이 문제 bfs로가능? dfs해야하지않나?
    /*
       방문을 해당 노드에 대한 체크로만 고정해서 생각해서 이런듯? 
       방문은 정의에 따라 노드자체는 방문 여러번해도되고 같은 간선 이용횟수에 대한 정의도 가능
       
       근데 보통 자료구조가 여러개로 흩어져있어도 인덱스를 식별자로해서 매핑하면 해결되는 경우가많음
       인접리스트로 구성한경우 왜 티켓정보에 대한 매핑이 불가능해지는가?
       티켓번호에 대한 정보가 유실됨
    */
    public boolean dfs(int depth, String target, boolean[] used) {
        if (depth == tickets.length) {
            System.out.println(depth);
            list.add(target); // 마지막
            return true;
        }   
        
        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(target)) {
                used[i] = true;
                list.add(target);
                if (dfs(depth + 1, tickets[i][1], used)) {
                    return true;
                }
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }
}