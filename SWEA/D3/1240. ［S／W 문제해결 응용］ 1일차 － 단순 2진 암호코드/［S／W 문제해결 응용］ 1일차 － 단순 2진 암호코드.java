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
    public static Map<String, Integer> map = new HashMap<>();
    public static int LEN = 56;
    public static int N = 0;
    public static int M = 0;
    public static int[][] board;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
			
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
		map.put("0001011", 9);
        
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // N * M
			StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                	int num = str.charAt(j) - '0';
                    board[i][j] = num;
                }
            }
            
            /*
            	홀수 3배, 짝수는 그냥.
                근데 여기서 홀,짝은 보드전체 기준이 아니라 startIdx가 무조건 짝수취급되어야함에 주의
                결국 홀짝보다 i % 2가 startIdx % 2와 같으면 이것이 3배, 다르면 1배
            */
            // 시작열과 끝열 구함
            int endCol = findEndCol();
            int startCol = endCol - LEN +1;
            int startRow = findStartRow(endCol);
           
       
            
			//for (int i = startRow; i <= endRow; i++) {
                //for (int j = startCol; j <= endCol)
                /*
                	7개씩 끊어서 숫자 변환하고 3배수할지 안할지 결정해야함
                    i정보로 유지못하고 별도 변수로 분리해서 +7해서 체크하거나 boolean flag 설정으로 스위칭
                */
            int sum = 0;
            int count = 8;
            int startIdx = startCol;
            int result = 0;
            boolean isOdd = true; // 맨처음 true시작
            while (count > 0) {
                int number = convertNumber(startRow, startIdx, board);
                if (isOdd) {
                    sum += 3 * number;
                    result += number;
                    isOdd = false;
                } else {
                    sum += number;		
                    result += number;
                    isOdd = true;
                }
                startIdx += 7; // 공통
                count--;
            }
            sb.append("#").append(test_case).append(" ");
            if (sum % 10 == 0) {
            	sb.append(result);    
            } else {
                sb.append(0);
            }
            sb.append("\n");
		}
        System.out.print(sb.toString());
	}
    
    public static int convertNumber(int startRow, int startCol, int[][] board) {
    	StringBuilder sb = new StringBuilder();
        for (int j = startCol; j <= startCol + 6; j++) {
            sb.append(board[startRow][j]);
        }
        return map.get(sb.toString());
    }
    
    public static int findStartRow(int endCol) {
    	for (int i = 0; i < N; i++) {
            if (board[i][endCol] == 1) {
                return i;
            }
        }
        return -1;
    }
    
                      
    public static int findEndCol() {
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
            	if (board[i][j] == 1) {
                    return j;
                }
            }
        }
        return -1; // board 전체가 0일때 -1 반환
    }
}