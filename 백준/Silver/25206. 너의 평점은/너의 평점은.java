import java.io.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, Double> gradeToPoint = Map.of(
                "A+", 4.5,
                "A0", 4.0,
                "B+", 3.5,
                "B0", 3.0,
                "C+", 2.5,
                "C0", 2.0,
                "D+", 1.5,
                "D0", 1.0,
                "F", 0.0
        );

        Double sum = 0.0;
        Double scoreSum = 0.0;
        for (int i = 0; i < 20; i ++) {
            String[] split = br.readLine().split(" ");
            double score = Double.parseDouble(split[1]);
            if (!split[2].equals("P")) {
                Double num = gradeToPoint.get(split[2]);
                scoreSum += score;
                sum += score * num;
            }
        }
        double avgScore = sum / scoreSum;

        bw.write(String.valueOf(avgScore));
        bw.flush();
        bw.close();
        br.close();
    }

}