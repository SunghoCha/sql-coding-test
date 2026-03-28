import java.util.*;
class Solution {
    public static List<Double> list = new ArrayList<>();
    public double[] solution(int k, int[][] ranges) {
        
        /*
            정적분 구간의 시작점이 끝점보다 크다면 유효하지않으므로 -1반환
            n + (-b) < 0인 케이스.
        */
        list = new ArrayList<>();
        int n = recur(k, 0);
        double[] ans = new double[ranges.length];        
        interg(k);
        
        for (int i = 0; i < ranges.length; i++) {
            System.out.println("**********************");
            int[] cur = ranges[i];
            int a = cur[0];
            int b = cur[1];
            // b는 항상 음수이거나 0.
            // a ~ n + b로하고 n + b가 음수이면 -1반환
            int end = n + b;
            if (end < 0 || end < a) {
                ans[i] = -1;
                continue;
            }
            
            double sum = 0;
            for (int j = a; j < end; j++) {
                sum += list.get(j);
            }
            ans[i] = sum;
        }

        return ans;
    }
    /*
        (현재y + 다음y) / 2
        재귀로하나? 각각?
        arr전달하고 재귀로 채워서?
        들어온 수 n과 n을 기반으로 구한 다음 수 -> 현재y와 다음y. 넓이 구해서 arr추가
        다음y를 다시 전달해서 재귀.
        전달하는 이 y(int n)이 1이라면 return;
    */
    public void interg(int n) { 
        if (n == 1) {
            return;        
        }
        
        int next = 0;
        if (n % 2 == 0) {
            next = n / 2;            
        } else {
            next = 3 * n + 1;          
        }
        double result = ((double) n + next) / 2;
        list.add(result);  
        interg(next);
        
    }
    
    public int recur(int n, int count) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 1;
        }
        count++;
        
        if (n > 1) {
            return recur(n, count);
        } else {
            return count;
        }
       
    }
}