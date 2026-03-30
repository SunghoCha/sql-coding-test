import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        
        /*
            과제 시작시간마다 새로운 과제는 항상 시작
            진행중이던 과제는 멈추고 어딘가에 저장
            진행과제 끝냈을때 잠시 멈춘 과제 있으면 멈춰둔 과제 이어서 진행
             그런데 만약 과제끝낸시각에 새로 시작해야하는 과제와 잠시 멈춰둔 과제가 모두 있다면
             새로 시작해야하는 과제 부터진행
                그런데 새로운 과제 시작할떄마다 이게 최우선인데 이런 상황이 발생한다는건
                진행되는 과제가 끝나는순간 새로운과제 시작시간과 겹친 상황을 말하는건가
             
             멈춘 과제 여러개면 가장 최근 멈춘 과제부터 진행
             이러면 스택에 넣으면 되나?
             
             과제를 끝낸순서대로 이름 반환해야함
            
             현재 진행중인과제가 있는지 체크한다
             있으면 해당 과제를 스택에 넣고 현재 과제 진행(이건 어떻게 표현?)
             이것도 자료구조에 넣고 해야하나?
             생각해보니 이게 루프를 과제들 시작시간으로만 하면 안됨
             진행중인 과제가 종료되는 시점까지 총 2가지 종류의 시점이 필요함
             이 시점은 어떻게 캐치? 종료시간을 기록해놔야할거같은데
             plans거 1000으로 짧긴하지만 그렇다고 종료시간을 미리 다 구해놓고 다시 루프도는건 비효율
             한 번 루프에서 체크하는게 나아보임
             for문으로 과제시작지점 시간체크하고 그 안에 루프나 while로 종료시점 체크?
             그냥 시간을 0부터 24 * 60까지 돌면서 하면안되나?
             이런다고 시작, 종료시각 어떻게 잡아내지? 
             
        */
        List<Plan> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            String[] split = plans[i];
            String name = split[0];
            int start = convert(split[1]);
            int period = Integer.parseInt(split[2]);
            list.add(new Plan(name, start, period));           
        }
        list.sort((a, b) -> {
            return a.start - b.start;
        });
        /*
            현재 작업을 허용된 시간만큼 수행하고..
        */
        Deque<Plan> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); i++) {
            Plan plan = list.get(i);    
            if (i == list.size() - 1) {
                ans.add(plan.name);        
            } else {
                Plan next = list.get(i + 1);
                int end = plan.start + plan.period;
                if (end <= next.start) {
                    ans.add(plan.name);
                    int gap = next.start - end;
                    while (!stack.isEmpty() && gap > 0) {
                        Plan oldPlan = stack.pop();
                        if (gap >= oldPlan.period) {
                            ans.add(oldPlan.name);
                            gap -= oldPlan.period;
                        } else {
                            oldPlan.period -= gap;
                            stack.push(oldPlan);
                            gap = 0;
                        }
                    }
                } else if (end > next.start) {
                    plan.period = end - next.start;
                    
                    stack.push(plan);
                }
            }
            
        }   
        while (!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }
        
        return ans.toArray(new String[0]);
    }
    
    public int convert(String str) {
        String[] split = str.split(":");
        return 60 * Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
    }
    
    public static class Plan {
        String name;
        int start;

        int period;
        
        Plan(String n, int s, int p) {
            this.name = n;
            this.start = s;
            this.period = p;
        }
    }
}