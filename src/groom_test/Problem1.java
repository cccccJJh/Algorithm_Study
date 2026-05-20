package groom_test;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem1 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 첫 줄에서 N(칸의 개수)과 Q(작업 횟수)를 읽어옵니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 2. 1번 칸부터 N번 칸까지 사용하기 위해 크기가 N + 1인 배열을 만듭니다.
        String[] arr = new String[n + 1];

        // 3. 두 번째 줄부터 N개의 문자열을 배열에 차례대로 저장합니다.
        for (int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
        }

        // 출력을 한 번에 모아서 하기 위해 StringBuilder를 준비합니다.
        StringBuilder sb = new StringBuilder();

        // 4. Q번의 작업 명령을 처리합니다.
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (type == 1) {
                // 1번 명령: k번 칸의 문자열을 새로운 문자열 s로 변경
                String s = st.nextToken();
                arr[k] = s;
            } else if (type == 2) {
                // 2번 명령: k번 칸의 문자열을 출력 버퍼에 추가
                sb.append(arr[k]).append("\n");
            }
        }

        // 5. 모아둔 결괏값을 한 번에 출력합니다.
        System.out.print(sb.toString());
    }
}
