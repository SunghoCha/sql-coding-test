import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int size = score.length;
        int idx = size - 1;
        while (size >= m) {
            idx = idx - m; // 다음 시작 지점
            answer += score[idx + 1] * m;
            size -= m;
        }
        return answer;
    }
}