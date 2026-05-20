package groom_test;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[] cells = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            cells[i] = br.readLine().trim();
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (type == 1) {
                cells[k] = st.nextToken();
            } else {
                sb.append(cells[k]).append('\n');
            }
        }

        System.out.print(sb);
    }
}
