import java.util.*;

/**
 * 광물 캐기 - 돌 곡괭이 비용 기준 정렬 (동률 시 오답 가능성 있음)
 *
 * 전략: 그리디 - 5개씩 묶어서 돌 곡괭이 비용 내림차순 정렬 후
 *       좋은 곡괭이부터 배정
 */
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        // 캘 수 있는 광물 수 = 곡괭이 수 * 5
        int canMine = Math.min(minerals.length, totalPicks * 5);

        // 5개씩 묶어서 돌 곡괭이 비용 계산
        List<int[]> groups = new ArrayList<>(); // [돌비용, 그룹인덱스]
        for (int i = 0; i < canMine; i += 5) {
            int stoneCost = 0;
            for (int j = i; j < Math.min(i + 5, canMine); j++) {
                if (minerals[j].equals("diamond")) {
                    stoneCost += 25;
                } else if (minerals[j].equals("iron")) {
                    stoneCost += 5;
                } else {
                    stoneCost += 1;
                }
            }
            groups.add(new int[]{stoneCost, i});
        }

        // 돌 비용 내림차순 정렬
        groups.sort((a, b) -> b[0] - a[0]);

        // 좋은 곡괭이부터 배정
        int[] pickLeft = {picks[0], picks[1], picks[2]};
        // 곡괭이별 광물 비용표: [곡괭이종류][광물종류]
        int[][] cost = {
            {1, 1, 1},   // 다이아 곡괭이
            {5, 1, 1},   // 철 곡괭이
            {25, 5, 1}   // 돌 곡괭이
        };

        int totalFatigue = 0;
        for (int[] group : groups) {
            int startIdx = group[1];

            // 사용할 곡괭이 선택 (다이아 → 철 → 돌)
            int pickType = -1;
            for (int p = 0; p < 3; p++) {
                if (pickLeft[p] > 0) {
                    pickType = p;
                    pickLeft[p]--;
                    break;
                }
            }
            if (pickType == -1) break;

            // 해당 그룹의 피로도 계산
            for (int j = startIdx; j < Math.min(startIdx + 5, canMine); j++) {
                int mineralType;
                if (minerals[j].equals("diamond")) {
                    mineralType = 0;
                } else if (minerals[j].equals("iron")) {
                    mineralType = 1;
                } else {
                    mineralType = 2;
                }
                totalFatigue += cost[pickType][mineralType];
            }
        }

        return totalFatigue;
    }
}
