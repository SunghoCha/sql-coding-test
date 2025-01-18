


import java.io.*;
import java.util.*;

public class Main {

    private static int count = 0;
    private static int tryNum;
    private static int result = 0;
    private static boolean flag = false;
    private static int[] B;
    private static int[] input2;
    private static int idx = -1;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (compareArray(A)) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        qSort(A, 0, size - 1);

        if (flag) {
            bw.write("1");
            bw.flush();
            bw.close();
        } else {
            bw.write("0");
            bw.flush();
            bw.close();
        }
    }

    private static void qSort(int[] A, int left, int right) {
        if (left < right && !flag) {
            int pivotIdx = partition(A, left, right);
            qSort(A, left, pivotIdx - 1);
            qSort(A, pivotIdx + 1, right);
        }
    }

    private static int partition(int[] A, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = A[right];

        while(lo < hi){
            // lo의 요소가 pivot보다 큰 값을 먼저 찾아야 됨
            while(lo < hi && A[lo] < pivot){
                lo++;
            }

            while(lo < hi && A[hi] >= pivot){
                hi--;
            }

            swap(A, lo, hi);
            compareArray(A); // 스왑해줄때마다 B배열과 비교
        }
        swap(A, hi, right);
        compareArray(A);
        return hi;
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static boolean compareArray(int[] A) {
        if (idx < 0) idx = 0;
        for (int k = idx; k < A.length; k++) {
            if (A[k] != B[k]) {
                idx = k - 1; // 일치하는 input의 마지막 인덱스 저장
                return false;
            }
        }
        flag = true;
        return true;
    }

}

