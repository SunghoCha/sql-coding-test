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
    static int N = 0;
    static int count = 0;
    static boolean[] cols;
    static boolean[] rightDownDiag; // i - j + (n+1)
    static boolean[] rightUpDiag; // i + j
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		/*
		   N-queen
           n이 최대 10. dfs 가지치기,백트래킹으로 가능할 듯
           하나의 좌표 i,j에 놓이면 해당 행과 열 불가, 대각불가.
           이 3개의 제약조건을 3개의 배열로 저장?
			대각 조건은 어떻게? 왼대각 오른대각? 
            행은 반복문에서 수행되니까 열배열과 대각배열 2개?
            row - col이 일정 오른쪽아래각 -> -(n-1) ~ n-1 => 총 2n - 1개 -> 0 ~ 2n-2 인덱스 사용. (n+1)해서 보정?
            row + col이 일정 오른쪽위대각 -> 0 ~ 2n -2 -> 총 2n - 1개 -> 0 ~ 2n-2 인덱스 사용. 보정필요없음
		*/
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
            cols = new boolean[N];
            rightDownDiag = new  boolean[2*N + 1]; // i - j + (n+1)
            rightUpDiag = new boolean[2*N + 1]; // i + j
            count = 0;
            dfs(0);
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
        System.out.print(sb.toString());
	}
    // depth : 행
    public static void dfs(int i) {
        if (i == N) {
            count++;
            return;
        }
        
        for (int j = 0; j < N; j++) {
        	if (cols[j]) continue;
            if (rightDownDiag[i - j + N - 1]) continue;
            if (rightUpDiag[i + j]) continue;
            cols[j] = true;
            rightDownDiag[i - j + N - 1] = true;
            rightUpDiag[i + j] = true;
            
            dfs(i + 1);
            
            cols[j] = false;
            rightDownDiag[i - j + N - 1] = false;
            rightUpDiag[i + j] = false;
        }
    }
}