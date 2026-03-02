class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        
        /*
            keymap에서 map으로 문자당 최소값으로 저장. 늦게 나오는 중복값 필요없음
            keymap들에서 중복으로 문자가 있을 수 있음. 매번 문자열마다 keymap 순회?
            근데 String.indexOf로 최소값얻으면 됨. 이걸 루프돌면서 최소값 얻어서 값누적
            해당 문자열에 대해서 값누적끝나면 answer에 추가
        */
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String target = targets[i];
            boolean hasMin = false;
            for (char ch : target.toCharArray()) {
                int min = Integer.MAX_VALUE;
                hasMin = false;
                for (String key : keymap) { // keymap 순회하면 해당 ch의 최소 인덱스구함
                    int idx = key.indexOf(ch);
                    if (idx != -1 && idx < min) {
                        hasMin = true;
                        min = idx;
                    }
                }
                if (!hasMin) { 
                    // 해당 ch접근불가면 그 단어는 더이상 살펴볼 필요도없으므로 break
                    
                    break;
                }
                // 최소인덱스 + 1 값이 누르는 횟수
                count += min + 1;
            }
            // count가 구해짐 이걸 answer에 더함
            if (hasMin) {
                answer[i] = count;
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
}