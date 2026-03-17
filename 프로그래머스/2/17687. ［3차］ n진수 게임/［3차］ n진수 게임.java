class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        /*
            n진법, 미리구할숫자개수 t. 총인원m, 튜브의 순서 p
            n진법으로 가장작은수부터 자리수올리기전? 유닛으로 나열? 이게 어려운듯
            m * (t - 1) + p 대충 이정도 구해야하는데 그냥 m * t로 구해놓고 하면안되나?
            다 변환할필요있나? mod 이용해서 t개수만큼만 구하면 되는거아닌가?
            근데 일대일대응관계가 아님. 진법이 다르면 당연..
            근데 돌려야하는 루프의 범위는  m * (t - 1) + p보다 작은 숫자일테니
            변환해야하는 숫자범위를 대충 1 ~ m * (t - 1) + p로 하면 되려나?
        */
        char[] chars = "0123456789ABCDEF".toCharArray();
        
        int num = m * (t - 1) + p;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= num; i++) {
            sb.append(convert(i, n, chars));
        }
        char[] target = sb.toString().toCharArray();
        
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            if ((i + 1) % m == p % m) {
                answer += target[i];    
                count++;
                if (count == t) {
                    break;
                }
            }
        }
        return answer;
    }
    
    public String convert(int n, int k, char[] chars) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append(0);
        }
        while (n > 0) {
            sb.append(chars[n % k]);
            n /= k;
        }
        return sb.reverse().toString();
    }
}