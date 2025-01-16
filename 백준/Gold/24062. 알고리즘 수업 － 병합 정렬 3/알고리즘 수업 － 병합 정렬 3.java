import java.io.*;
import java.util.*;

public class Main {

    private static int N; // 배열 A의 크기 N
    private static int idx = -1;

    private static int[] A;
    private static int[] B;
    private static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        tmp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        bw.write("0\n");
        bw.flush();
        bw.close();
    }

    // 배열 A와 배열 B 비교
    private static boolean sameIdx() {
        for (int i = idx + 1; i < N; i++) {
            if (A[i] != B[i]) {
                idx = i - 1;
                return false;
            }
        }
        return true;
    }

    // 결과 출력 후 종료
    private static void print(int n) throws IOException {
        System.out.println(n);
        System.exit(0);
    }

    // 병합
    private static void merge(int p, int q, int r) throws IOException {
        int i = p;
        int j = q + 1;
        int t = 1;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 1;

        while (i <= r) {
            if (A[i] != tmp[t]) {
                if (i <= idx) {
                    print(0);
                }
                A[i] = tmp[t];
                if (sameIdx()) {
                    print(1);
                }
            }
            i++;
            t++;
        }
    }

    // 병합 정렬
    private static void mergeSort(int p, int r) throws IOException {
        if (sameIdx()) {
            print(1);
        }

        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }
}
