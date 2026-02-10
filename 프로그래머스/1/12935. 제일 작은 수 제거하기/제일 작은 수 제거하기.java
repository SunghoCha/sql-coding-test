class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return new int[]{-1};
        }
        int min = Integer.MAX_VALUE;
        int[] answer = new int[length - 1];
        for (int i = 0; i < length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != min) {
                answer[index++] = arr[i]; 
            }
        }
        return answer;
    }
}