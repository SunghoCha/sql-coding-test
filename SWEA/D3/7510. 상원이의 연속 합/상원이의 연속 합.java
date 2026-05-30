
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
            int left = 1;
            int right = 1;
            int sum = 1;
            int count = 0;
            /*
            	left <= N, right <= N, left <= right
                left <= right를 벗어나는 상황 : left가 커져야함 == 현재 값이 left ==right이고 N보다 크다는 의미. -> 불가능
                right <= N 을 벗어나는 상황 : right가 커져야함 == 현재 right가 N에 있고 현재값은 최소 right이상인 상황. 즉 최소 N이상. 근데 N보다작아서 right를 키운다 -> 불가능
                left <= N 을 벗어나는 상황 : 1. left가 커져야함 == 현재 범위의 합이 N을 초과함. -> left 증가 불가능
                2. sum == N을 만족한후 left가 증가하는 일반 규칙. 이 떄 left가 이미 N인 경우?
            */
            while (left <= N) {
                if (sum < N) {
                    right++;
                    sum += right; 
                } else if (sum > N) {
                    sum -= left;
                    left++;
                } else {
                    count++;
                    sum -= left;
                    left++;
                }
            }
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        System.out.print(sb.toString());
	}
}