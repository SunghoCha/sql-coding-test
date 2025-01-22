


import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb;
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        long sqrt =(long) Math.sqrt((double) N);

        bw.write(String.valueOf(sqrt));
        bw.flush();
        bw.close();
    }



}

