
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        /*
        	어떤 것이 할인가이고 어떤 것이 정상가인지를 구별해야한다. 오름차순 정렬되어있음
            가장 앞은 무조건 할인가이지만 이게 중요한거같지는않음. 정렬된 순서는 맨앞을 제외하고는 어떤것이 할인가이고 정상가인지 정해져있지않음
            그렇다면 맨앞부터 하나씩 꺼내서 확인해야함. 나의 3/4 가격이 존재하는지부터 체크?
            없으면? 난 정상가가 아님.. 있으면? 있다고해서 무조건 정상가는 아닐 가능성 존재. 이 경우를 제대로 파악하고 어떻게 대처할 것인지?
            (90) (90) 120 120 (120) 160 
            120 케이스를 보면 할인가 90으로 카운팅된게 있음? 하나를 소모하고 자기자신은 정상가?
            3번째 120 입장에서 할인가 90이 없음 자신은 할인가. -> 할인가 카운팅. 160입장에서 앞에 할인가 120있음. 그래서 정상가
            
            
        */
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Long, Integer> map = new HashMap<>();
            long[] arr = new long[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                long num = Long.parseLong(st.nextToken());
                arr[i] = num;
            }
            sb.append("#").append(test_case).append(" ");
            for ( int i = 0; i < 2 * N; i++) {
                long num = arr[i];
                long discount = num * 3 / 4;
                int count = map.getOrDefault(discount, 0);
                if (count == 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1); //  내가 할인가 이므로 등록
                    sb.append(num).append(" ");
                } else{ 
                 	map.put(discount, count - 1); // 할인가 1 감소   
                }
            }
            sb.append("\n");
           
		}
        System.out.print(sb.toString());
	}
}