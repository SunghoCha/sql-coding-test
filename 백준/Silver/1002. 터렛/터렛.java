import java.util.*;
import java.io.*;

public class Main {
    BufferedReader br;
    BufferedWriter bw;
    StringTokenizer st;
    
    public static void main(String[] arg) throws Exception {
        new Main().solution();
    }
    
    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            
            int d = ((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
            int rSum = (r1+r2)*(r1+r2);
            int rDiff = (r1-r2)*(r1-r2);
            int ans = 0;
            if (d == 0 && r1 == r2) {
                ans = -1;
            } else if (d > rDiff && d < rSum) {
                ans = 2;
            } else if (d == rDiff || d == rSum) {
                ans = 1;
            } else {
                ans = 0;
            }
      
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}