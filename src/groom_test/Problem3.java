package groom_test;
import java.io.*;
import java.util.*;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) {
                listX.add(cost);
            } else {
                listY.add(cost);
            }
        }

        // 가격 기준 오름차순 정렬
        Collections.sort(listX);
        Collections.sort(listY);

        int numX = listX.size();
        int numY = listY.size();

        // 1. 최대 충전 가능한 배터리 개수 계산
        int takeA = Math.min(numX, A);
        int takeB = Math.min(numY, B);
        int remX = numX - takeA;
        int remY = numY - takeB;
        int takeC = Math.min(remX + remY, C);

        int maxBatteries = Math.min(A + B + C, takeA + takeB + takeC);

        // 누적 합 배열 생성 (최소 비용 계산용)
        long[] prefX = new long[numX + 1];
        for (int i = 0; i < numX; i++) prefX[i + 1] = prefX[i] + listX.get(i);

        long[] prefY = new long[numY + 1];
        for (int i = 0; i < numY; i++) prefY[i + 1] = prefY[i] + listY.get(i);

        long minCost = Long.MAX_VALUE;

        // 2. X타입 충전기를 i개 구매할 때의 최소 비용 탐색
        for (int i = 0; i <= numX; i++) {
            // X타입 충전기를 i개 살 때, 감당할 수 있는 배터리 계산
            int xToA = Math.min(i, A);
            int xToC = i - xToA; // X타입이 C를 충전하는 개수

            // 필요한 총 배터리 개수가 maxBatteries이므로, Y타입이 충전해야 하는 타겟 개수 계산
            // Y가 채워야 하는 최소 개수와 최대 허용 개수를 구합니다.
            // i개와 j개의 조합이 유효한지 체크해야 합니다.

            // X가 처리하고 남은 배터리 요구량 계산
            int reqA = A - xToA; // 미처 채우지 못한 A는 충전 불가 (X만 가능하므로 i가 A보다 작으면 안 채워짐)
            // 즉, i개로 A를 다 못 채우면 그 격차만큼은 최대 개수에서 빠져야 함.
            // 위에서 구한 maxBatteries를 만족하려면 아래 조건을 만족하는 j를 찾아야 합니다.

            // 완벽한 매칭을 위해 j(Y 충전기 개수)의 범위를 제한합니다.
            // j는 전체 maxBatteries - (X가 충전할 수 있는 최대 배터리 수) 보다는 커야 합니다.

            // 직관적으로: X를 i개, Y를 j개 살 때 총 충전 가능 개수가 maxBatteries가 되는지 확인
            // i개와 j개로 처리 가능한 최대 배터리 = min(A, i) + min(B, j) + min(i - min(A,i) + j - min(B,j), C)
            // 이 값이 maxBatteries와 같다면 유효한 조합입니다.

            // 효율적인 탐색을 위해 j를 이분탐색하거나, 혹은 조건에 맞는 j의 범위를 좁혀서 계산합니다.
            // j가 증가하면 충전 가능 개수도 단조 증가하므로 투 포인터나 수식으로 최적의 j를 찾을 수 있습니다.

            // 여기서는 i를 고정했을 때 필요한 최소 j를 직접 계산해봅시다.
            // Y로 채워야 하는 B의 개수 = Math.min(numY, B);
            // i와 j의 합은 최소한 maxBatteries 보다는 작거나 같을 수 없습니다. (충전기 1개당 배터리 1개이므로 i + j >= maxBatteries)
            // 또한 충전기는 배터리보다 많이 살 필요가 없으므로 i + j == maxBatteries 인 지점 근처를 보면 됩니다.

            int j = maxBatteries - i;
            if (j >= 0 && j <= numY) {
                // i개와 j개로 maxBatteries를 만들 수 있는지 검증
                int curA = Math.min(i, A);
                int curB = Math.min(j, B);
                int curC = Math.min((i - curA) + (j - curB), C);

                if (curA + curB + curC == maxBatteries) {
                    long cost = prefX[i] + prefY[j];
                    minCost = Math.min(minCost, cost);
                }
            }
        }

        System.out.println(maxBatteries + " " + minCost);
    }
}