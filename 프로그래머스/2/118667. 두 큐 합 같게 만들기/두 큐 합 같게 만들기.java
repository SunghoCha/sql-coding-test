class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        /*
            3 2 7 2 . 4 6 5 1
            큐에 현혹될 필요없음
            하나의 배열을 두 개로 나누는 지점을 이동시키면서 최소카운트 찾기
            일단 다 더해서 합 얼마인지구하고 반값
            
            두 배열을 하나로 합치고 n-1에 포인터두고 시작하면될듯?
            그런데 투포인터 윈도우로하면되지않나? 0, n-1에 두고
            두 포인터가 각각 움직일때마다 횟수추가
            윈도우의 사이즈는 정해지지않음
                
            0 ~ n - 1까지의 합을 우선 구한다?
            합 초과면 start++ (queue2로 옮기는 행위)
            합이 작으면 end++ (queue1로 옮기는 행위)
            
            근데 합찾았다고 종료하는게 아님. 계속찾으면서 해당 sum일때의 count를 추출하고
            count후보들 중 min값을 찾아야함
        
        */
        int n = queue1.length;
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
        }
        for (int i = n; i < 2 * n; i++) {
            arr[i] = queue2[i - n];
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += queue1[i] + queue2[i];
        }
        long half = sum / 2;
        int start = 0;
        int end = n - 1; // queue1의 마지막점 
        
        sum = 0; // 재활용
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        while (start <= end) { // end가 2n - 1 초과하면 break?
            if (sum == half) {
                min = Math.min(min, count); 
                start++;    // 진행은 항상 오른쪽으로
                
            } else if (sum < half) {
                end++;
                if (end >= 2 * n) {
                    break;
                }
                sum += arr[end];
                count++;
            } else if (sum > half) {
                sum -= arr[start];
                start++;        
                count++;
            } 
        }
        
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}