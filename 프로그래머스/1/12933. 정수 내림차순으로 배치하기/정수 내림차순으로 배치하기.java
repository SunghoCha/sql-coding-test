class Solution { // 선택정렬로 풀어보기
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        int h = 0;
        while (n > 0) {
            arr[h] = (int) (n % 10);
            n /= 10;
            h++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb.append(arr[k]);
        }
        
        return Long.parseLong(sb.toString());
    }
}