
import java.util.*;
import java.io.*;


class Solution
{
	public static int N = 0;
    public static int len = 0;
    public static boolean possible;
    public static boolean[] visited;
    public static int[] digits;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = br.readLine();
            len = str.length();    
			N = Integer.parseInt(str);
            visited = new boolean[len];
            digits = new int[len];
            possible = false;
            for (int i = 0; i < len; i++) {
                digits[i] = str.charAt(i) - '0';
            }
            dfs(0, 0);
            sb.append("#").append(test_case).append(" ");
            if (possible) {
                sb.append("possible");
            } else {
                sb.append("impossible");
            }
			sb.append("\n");
		}
        System.out.print(sb.toString());
	}
    
    public static void dfs(int depth, int value) {
        if (depth == len) {
        	if (value > N && value % N == 0) {
                possible = true;
            }	    
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                int digit = digits[i];
                if (depth == 0 && digit == 0) continue;
                
                visited[i] = true;
                dfs(depth + 1, value * 10 + digit);
                visited[i] = false;
                
            }
        }
        
    }
}

