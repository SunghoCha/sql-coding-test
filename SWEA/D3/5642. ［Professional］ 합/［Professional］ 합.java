
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());	
			StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            
            int[] prefix = new int[N];
            prefix[0] = arr[0];
            for (int i = 1; i < N; i++) {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            int min = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, prefix[i] - min);
                min = Math.min(min, prefix[i]);
            }
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
        System.out.print(sb.toString());
	}
}