/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{	
    public static int[] scores;
    public static int[] cals;
    public static int calLimit = 0;
    public static int max = 0;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		

		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            calLimit = Integer.parseInt(st.nextToken());
            scores = new int[N];
            cals = new int[N];
            max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                scores[i] = score;
                cals[i] = cal;
            }
            dfs(0, 0, 0, N); // idx, scoreSum, calSum
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
        System.out.print(sb.toString());
	}
    
    public static void dfs(int idx, int scoreSum, int calSum, int N) {
        if (calSum > calLimit) { // 조기종료
            return;
        }
        
        if (idx == N) { // 0 ~ N -1
        	max = Math.max(max, scoreSum);	    
            return;
        }
        
        
        dfs(idx + 1, scoreSum, calSum, N); // 선택안함
        dfs(idx + 1, scoreSum + scores[idx], calSum + cals[idx], N); // 선택
    }
        
}