import java.util.*;
class Solution {
    boolean[] table;
    int n = 0;
    public String solution(int n, int k, String[] cmds) {
        this.n = n;
        /*
            행의 개수n, 처음행위치k
            
            행을 삭제하고 복구하는 메커니즘?
            행을 삭제하면 아래 있던행들이 밀려서 올라오긴하는데..
            복구하면 다시 중간에 넣어야함. 이걸 실제로하면 시간복잡도가 클텐데
            다른 방식이 가능한지 고려해봐야함
            가장 최근에 제거된 정보를 저장해놓고 복구인가?
            아니면 기존자료에서 소프트딜리트처럼 다루나?
            하드딜리트로하면 너무 복잡해지지않나?
            애초에 행번호를 그냥 고정하고 해당 위치에 상태값을 넣는게?
            포인터로 이동할떄 해당 상태값이 딜리트상태가 아니면 카운트증가해서 몇칸이동인지 체크하는방식
            최종마지막에도 이 boolean? 상태값으로 체크하면 될듯?
            
            주의사항
            삭제시 마지막 행인지 체크해야함.
            마지막이면 바로윗행 선택, 아니면 아래행 선택?
            삭제한 행에 대한 정보를 가지고 있어야함. 이건 큐에 인덱스 넣어서 관리해야할듯
            n만큼의 boolean배열 생성하고 해도 충분하려나? 다른 상태가 필요한가?
            
        */
        /*
            리뷰받음
            일반 배열로해서 시간초과. 소프트딜리트로하더라도 삭제위치건너뛰기나 마지막위치체크에서
            n 복잡도. 이걸 매 커맨드마다 하니 n^2이 됨.
            이걸 1복잡도로 해결해야함
              
        */
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] deleted = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int idx = k;
        for (String cmd : cmds) {
            if (cmd.length() > 1) {
                String[] split = cmd.split(" ");
                String command = split[0];
                int count = Integer.parseInt(split[1]);
                if (command.equals("U")) {
                    for (int i = 0; i < count; i++) {
                        idx = prev[idx];
                    }
                } else { // D
                    for (int i = 0; i < count; i++) {
                        idx = next[idx];
                    }
                }
            } else {
                /*
                    내이전 노드의 다음이 나의 다음을 가리키도록한다
                    next[prev[idx]] = next[idx];
                    
                    내다음노드의 이전이 나의 이전을 가리키도록한다.
                    prev[next[idx]] = prev[idx];
                    
                    맨뒤 삭제면..
                */
                if (cmd.equals("C")) { // 맨앞 삭제와 맨 뒤 삭제 주의                  
                    if (prev[idx] != -1) { // 맨앞인덱스의 prev 체크
                        next[prev[idx]] = next[idx];       
                    }
                    if (next[idx] != n) { // 맨뒤인덱스의 next 체크
                         prev[next[idx]] = prev[idx];
                    }
                    deleted[idx] = true; 
                    stack.push(idx);
                    
                    if (next[idx] != n) { // 마지막이 아닌경우
                        idx = next[idx];
                    } else {
                        idx = prev[idx];
                    }
                /*
                    prev[del] = 예전 나의 이전노드
                    예전 나의 이전노드가 다시 next로 나를 가리키도록 만든다
                    next[prev[del]] = del
                    
                    next[del] = 예전 나의 다음노드
                    예전 나의 다음노드가 prev로 다시 나를 가리키도록 만든다
                    prev[next[del]] = del
                */
                } else { // Z
                    int del = stack.pop();
                    if (prev[del] != -1) {
                        next[prev[del]] = del;
                    }
                    if (next[del] != n) {
                        prev[next[del]] = del;
                    }
                    deleted[del] = false;
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (deleted[i]) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        return sb.toString();
    }
}
