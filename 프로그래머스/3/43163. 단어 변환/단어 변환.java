import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 1. target이 words 배열에 존재하는지 먼저 확인합니다. 없으면 0 반환.
        boolean hasTarget = false;
        for (String word : words) {
            if (word.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) {
            return 0;
        }

        // 2. BFS 탐색을 위한 큐와 방문 여부 배열 초기화
        Queue<WordNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.offer(new WordNode(begin, 0));

        // 3. BFS 탐색 시작
        while (!queue.isEmpty()) {
            WordNode current = queue.poll();

            // 목표 단어에 도달하면 현재까지의 걸음(steps) 수 반환
            if (current.word.equals(target)) {
                return current.steps;
            }

            // words 배열을 순회하며 변환 가능한 단어를 큐에 넣음
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(current.word, words[i])) {
                    visited[i] = true; // 방문 처리
                    queue.offer(new WordNode(words[i], current.steps + 1));
                }
            }
        }

        // 변환할 수 없는 경우 0 반환
        return 0;
    }

    // 두 단어가 딱 한 개의 알파벳만 다른지 확인하는 헬퍼 메서드
    private boolean canTransform(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            // 다른 글자가 2개 이상이면 더 볼 필요 없이 false 반환
            if (diffCount > 1) {
                return false;
            }
        }
        return diffCount == 1;
    }

    // 큐에 담을 단어와 현재까지의 변환 횟수를 묶어주는 내부 클래스
    private static class WordNode {
        String word;
        int steps;

        WordNode(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}