/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int N = 8;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10; // 무조건 10개
		
		/*
        	한 사이클에 5개. 1 2 3 4 5 감소
            8개의 숫자. -> 40턴으로 8사이클 돌면 모든 숫자가 15씩 감소
            이 때 0이 되버리면
        */
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test_num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
            int[] password = new int[N];
            for (int i = 0; i < N; i++) {
                password[i] = Integer.parseInt(st.nextToken());
            }
            int min = getMinNumber(password);
			int number = ((min - 1)  / 15) * 15; // 가장 작은값보다 1작은 값 기준으로 8사이클 돌린 배수로 값 제거
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                password[i] -= number; // 최소값도 1은 남았을거라 일단 0은 아직 없는 상태
                queue.offer(password[i]);
            }
            // 1, 2, 3, 4, 5를 빼면서 0이하가 나오면 offer하고 break하면 암호가 담긴 큐
            int diff = 1;
            while (true) {
            	int num = queue.poll();
                num -= diff;
                if (num <= 0) {
                    queue.offer(0);
                    break;
                }
                queue.offer(num);
                diff = (diff % 5) + 1;
            }
            sb.append("#").append(test_case);
            while(!queue.isEmpty()) {
            	sb.append(" ").append(queue.poll());    
            }
            sb.append("\n");
		}
        System.out.print(sb.toString());
	}
    
    public static int getMinNumber(int[] password) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < password.length; i++) {
            if (min > password[i]) {
                min = password[i];
            }
        }
        return min;
    }
}