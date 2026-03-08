import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        /*
            해당 지점에서 가장 크게 펼칠수있는 정사각형 면적구하기?
            크기도 최대 50 * 50이면 그냥 이렇게 풀어도될듯
            해당 지점에서 시작한다고치자 정사각형 면적 어떻게 구하지?
            해당x열에 대해 스캔? 근데 스캔으로 10칸가능한데 그 아래 5칸이면?
            스캔은 결국 x열 스캔방식일텐데 이러면 어떻게 찾지
            이러면 너무 어려우니 브루트포스로 큰 돗자리부터 넣으면서 확인
        */
        
        /*
            매 지점에서 가장큰 돗자리들어가는지확인
        */
        int clength = park.length;
        int rlength = park[0].length;
        Arrays.sort(mats);
        for (int k = mats.length - 1; k >= 0; k--) {
            int mat = mats[k];
            for (int i = 0; i < clength; i++) {
                if (i + mat > clength ) {
                    break;
                }
                for (int j = 0; j < rlength; j++) {
                    if (j + mat > rlength) {
                        break;
                    }
                    // 해당 i,j에서 돗자리 가능한지 체크
                    boolean isOk = true;
                    for (int a = 0; a < mat; a++) {
                        for (int b = 0; b < mat; b++) {
                            if (!park[i + a][j + b].equals("-1")) {
                                isOk = false;
                                break;
                            }    
                        }    
                    }
                    if (isOk) {
                        return mat;
                    }
                    
                    
                }
            }
        }
        
        return -1;
    }
}