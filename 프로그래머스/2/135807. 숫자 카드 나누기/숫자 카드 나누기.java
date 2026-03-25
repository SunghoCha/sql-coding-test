import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {        
        int aGcd = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            aGcd = gcd(aGcd, arrayA[i]);            
        }
        
        int bGcd = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            bGcd = gcd(bGcd, arrayB[i]);
        }
        
        int a = calcul(arrayA, bGcd);
        int b = calcul(arrayB, aGcd);
        
        return Math.max(a, b);
    }
    
    
    public int calcul(int[] arr, int gcd) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % gcd == 0) {
                return 0;
            }
        }
        return gcd;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}