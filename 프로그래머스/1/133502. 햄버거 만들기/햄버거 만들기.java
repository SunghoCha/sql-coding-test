class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        /*
            빵 야채 고기 빵이라는 상태?
            이전 상태들을 추적해야하고 이전 상태들이 연속된 상태로 존재해야함
            스택에 쌓다가 상태기계 변화하다가 조건만족하는 순간 스택에서 pop?
            pop은 어떻게? 상태연속이니까 앞에서 3개 뺀다고하자 그다음이 문제
            남은것들이 부분적으로 연속적인상태일 가능성 존재
            그렇다면 스택에 쌓는걸 단순 숫자가 아닌 상태를 가진 객체로?
            이 상태라는건 연속된건지 아닌지 체크하는?
            체크하지말고 그냥하자. 앞에 남아있는것들이 어떤식으로 남아있는지 모르니
            그냥 그떄그때 스택에서 꺼내서 확인하던지 해야함
            
            그냥 1 만나면 앞에 peek로 3 2 1꺼내는식으로?
        */
        int[] stack = new int [1000001];
        int idx = 0;
        for (int i = 0; i < ingredient.length; i++) {
            int num = ingredient[i];
            stack[idx] = num;
            idx++; // if문 분기로 가든 안가든 idx가 증가해야하므로 여기서 미리 증가시키고 
            // 아래 if문에선 >= 3이 아니라 >=4로 체크
            if (idx >= 4) { // idx++했기 때문에 방금 넣은값은 idx - 1에 있음
                if (stack[idx - 1] == 1 
                    && stack[idx - 2] == 3
                    && stack[idx - 3] == 2
                    && stack[idx - 4] == 1) {
                    idx -= 4;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}