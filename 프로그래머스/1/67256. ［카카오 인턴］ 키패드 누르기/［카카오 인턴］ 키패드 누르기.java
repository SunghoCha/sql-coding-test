class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        /*
            1,4,7 L
            3,6,9 R
            2,5,8,0 가까운쪽 -> 포인터 필요 -> 애초에 2차원 배열만들고 시작? 애매함 특수문자? 
            동일한 거리면 왼손잡이 OR 오른손잡이
            거리계산 방법?
            숫자값으로는 안되고 인덱스 지정해서 해야함. 상하좌우로 거리 계산하니까
            i인덱스차이 + j인덱스 차이가 거리
            
        */
        // 거리 계산용 배열만들까
        // {1,0,0} {2,0,1}... 
        
        int[][] pos = { // 0, 1, 2, ...
            {3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}
        };
        int[] left= {3,0}; // 다이얼
        int[] right = {3,2};
        // 1,4,7한번에 묶어서 처리하면 해당 위치를 못 잡아낼줄 알았는데 아님
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                left = pos[num];
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right = pos[num];
                sb.append("R");
            } else {
                int[] cur = pos[num];
                int leftDist = Math.abs(left[0] - cur[0]) + Math.abs(left[1] - cur[1]);
                int rightDist = Math.abs(right[0] - cur[0]) + Math.abs(right[1] - cur[1]);
                if (leftDist == rightDist) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = pos[num];
                    } else {
                        sb.append("R");
                        right = pos[num];
                    }
                } else if (leftDist > rightDist) {
                    sb.append("R");
                    right = pos[num];
                } else {
                    sb.append("L");
                    left = pos[num];
                }
            }
            
        }
        return sb.toString();
    }
}