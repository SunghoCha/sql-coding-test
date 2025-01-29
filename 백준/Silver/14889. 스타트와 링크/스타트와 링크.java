import java.io.*;
import java.util.*;

public class Main {

    private static int[][] input;
    private static boolean[] visited;
    private static int size;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        visited = new boolean[size];
        input = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTrackTeam(0, 0);
        System.out.println(min);
    }

    private static void backTrackTeam(int count, int start) {
        if (count == size / 2) {
            int diff = calculateDiff();
            min = Math.min(min, diff);
            return;
        }

        for (int i = start; i < size; i++) {  // 🔥 중복 방지
            if (!visited[i]) {
                visited[i] = true;
                backTrackTeam(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculateDiff() {
        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (visited[i]) {
                teamA.add(i);
            } else {
                teamB.add(i);
            }
        }

        int sumA = calculateSum(teamA);
        int sumB = calculateSum(teamB);

        return Math.abs(sumA - sumB);
    }

    private static int calculateSum(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                sum += input[team.get(i)][team.get(j)];
            }
        }
        return sum;
    }
}
