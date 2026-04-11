// 그리디 스캔 — v별로 최대 쌍 수 계산
// 시간복잡도: O(N) (가지치기 포함)
class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n < 2) return 0;

        // 등장 횟수 전처리
        int[] count = new int[n];
        for (int x : a) {
            count[x]++;
        }

        int maxPairs = 0;

        // 각 값 v에 대해 그리디 스캔
        for (int v = 0; v < n; v++) {
            // 가지치기: v의 등장 횟수가 현재 최대 이하면 스킵
            if (count[v] <= maxPairs) continue;

            int pairs = 0;
            boolean prevAvailable = false;

            for (int i = 0; i < n; i++) {
                if (a[i] == v) {
                    if (prevAvailable) {
                        // 앞 원소와 쌍
                        pairs++;
                        prevAvailable = false;
                    } else if (i + 1 < n && a[i + 1] != v) {
                        // 뒤 원소와 쌍
                        pairs++;
                        i++; // 뒤 원소도 사용했으니 건너뜀
                        prevAvailable = false;
                    } else {
                        // 쌍 못 만듦. v는 앞 원소 후보가 될 수 없음
                        prevAvailable = false;
                    }
                } else {
                    // v가 아닌 원소: 다음 v의 앞 원소 후보
                    prevAvailable = true;
                }
            }

            maxPairs = Math.max(maxPairs, pairs);
        }

        return maxPairs * 2;
    }
}
