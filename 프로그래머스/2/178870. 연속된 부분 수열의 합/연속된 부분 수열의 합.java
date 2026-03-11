class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int length = sequence.length;
        int min = Integer.MAX_VALUE; // 합이 k인 부분 수열의 최소 길이
        int preLeft = Integer.MAX_VALUE;
        int[] ans = new int[2];
        
        /*
            right범위가 이상한데? 그렇다고 < length로하면 로직내에서 인덱스초과됨
            while문 내에서 right++하고나서 유효범위일떄만 값에 추가하도록 변경
            left는 인덱스를 후추가하지만 right일 경우는 선추가하고나서 배열탐색해서 오류발생가능성 높음
            매우 주의해야함
        */
        while (left < length) {  
            if (sum == k) {
                int newLength = right - left + 1;
                if (newLength < min || (newLength == min && left < preLeft)) {
                    min = newLength;
                    ans[0] = left;
                    ans[1] = right;
                    preLeft = left;
                }
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < length) {
                    sum += sequence[right];
                } else {
                    break;
                }
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        return ans;
    }
    
    
}