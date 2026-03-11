class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        /*
            +1해서 /2하면 승자의 다음 번호
            결국 만나는 두 수는? 연속된 숫자. 1 2 3 4 
            2 3 은 못만나는건데 이걸 어떻게 잡아내지?
            홀수로 시작하는 연속된 두 숫자는 만남
            두 숫자를 각각 +1해서 /2로 하고 
            매번 (홀수로 시작하는 연속된 두 숫자는 만남)를 체크해야함 이걸 while조건에서?
        */
        int a1 = Math.min(a, b); // 1
        int b1 = Math.max(a, b); // 4
        int count = 1;
        while (!((a1 % 2 == 1) && b1 == (a1 + 1))) {
            a1 = (a1 + 1) / 2; // 1
            b1 = (b1 + 1) / 2; // 2
            count++;
        }
        

        return count;
    }
}