import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int tryNum = Integer.parseInt(st.nextToken());

        int[] input = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        /*
            1. 맨 처음 인덱스를 정렬된 것으로 간주하고 두 번쨰 인덱스부터 정렬된 배열과 비교해서 적절한 위치를 찾는 행동을 마지막 인덱스까지 반복
            2. 적절한 위치를 찾는건 정렬된 배열의 가장 오른쪽 인덱스(loc)와 미정렬된 배열의 가장 왼쪽 인덱스(loc + 1)의 크기를 비교한다.
            3. 왼쪽의 숫자가 크면 자리를 바꾸고 이걸 loc가 인덱스0보다 크거나 왼쪽의 숫자가 작을떄까지 반복한다.

         */

        int count = 0;
        for (int i = 1; i < input.length; i++) {
            int loc = i - 1;
            int newItem = input[i];
            while (loc >= 0 && newItem < input[loc]) {
                input[loc + 1] = input[loc];
                loc--;
                count++;
                if (count == tryNum) {
                    for (int j = 0; j < input.length; j++) {
                        sb.append(input[j]).append(" ");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            }
            if (loc + 1 != i) {
                input[loc + 1] = newItem;
                count++;
                if (count == tryNum) {
                    for (int j = 0; j < input.length; j++) {
                        sb.append(input[j]).append(" ");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
        if (count < tryNum) {
            bw.write("-1");
            bw.flush();
            bw.close();
        }

    }

}