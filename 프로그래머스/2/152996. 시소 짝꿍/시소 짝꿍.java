class Solution {
    public long solution(int[] weights) {
        long ans = 0;
        /*
            2,3,4. 
            weights 10만까지 가능
            3 * 3 가지 케이스에 10만개에서의 2개 뽑는 식으로하면 초과할듯
            
            1배 1.5배 1.75배 2배..
            단순하게 생각해서 1배만 체크한다고해보자
            카운팅 맵에 담는다? 카운트가 2이상이면 쌍이 존재?
            카운팅 - 1 개의 쌍이 존재하는거아닌가?
            맵에 담을때 각 숫자의 1배 1.5 1.75 2배에 하나씩 담는다
            그러니까 1개당 4개씩해서 10만 * 4로 최대 40만개 담음
            근데 이러면 이상하게되지않나? 원소가 1개여도 자기자신의 배수와 매핑되는데?
            카운팅 - 1개라서 가능?
            100 200 있다고치자 그러면 답은 1쌍인데
            100 200 175 300
            200 400 350 600  ... 우연인건지 이게 맞는건지...
            
            그리고 몸무게는 정수라서 17.5 이런것도 안되는데...
            
            그냥 작은 몸무게부터 오름차순으로 담고나서
            가장 작은 몸무게부터 1배 4/3배 1.5배 2배가 있는지 체크?
        */
        
        long[] count = new long[1001]; // 100 ~ 1000. 901개
        for (int w : weights) {
            count[w]++;
        }
        /*
            1, 3/2 4/3 2
        */
        for (int weight = 100; weight <= 1000; weight++) { // 901개니까 그냥 전체 루프
            long curCount = count[weight];
            if (curCount == 0) { // 없으면 스킵
                continue;
            }
            
            // 1배
            ans += curCount * (curCount - 1) / 2;
            
            // 3/2배
            if ((weight % 2) == 0) {
                int newWeight = weight * 3 / 2;
                if (newWeight <= 1000) {
                    ans += curCount * count[newWeight];    
                }
            }
            // 4/3배
            if ((weight % 3) == 0) {
                int newWeight = weight * 4 / 3;
                if (newWeight <= 1000) {
                    ans += curCount * count[newWeight];    
                }
            }
            
            // 2배
            if (weight * 2 <= 1000) {
                ans += curCount * count[weight * 2];
            }
            
        }
        return ans;
    }
}