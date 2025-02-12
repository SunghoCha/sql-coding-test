

    import java.io.*;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.StringTokenizer;


    public class Main {

        private static StringBuilder sb;

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
            sb = new StringBuilder();

            Map<Long, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i  = 0; i < N; i++) {
                long value = Long.parseLong(st.nextToken());
                map.put(value, 1);
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                long value = Long.parseLong(st.nextToken());
                Integer result = map.getOrDefault(value, 0);
                sb.append(result).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
            bw.close();
        }



    }