import java.io.*;
    import java.util.StringTokenizer;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());

            int day = 0;
            int sum = 0;

            int d = p - m;
            int i = (int) Math.ceil((double)(total - p) / d);


            bw.write(String.valueOf(i + 1));
            bw.flush();
            bw.close();
            br.close();
        }

    }
