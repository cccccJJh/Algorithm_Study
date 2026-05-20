package groom_test;

import java.io.*;
        import java.util.*;

public class Problem2 {
    // BFS 함수에서도 접근할 수 있도록 static으로 선언
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 1. 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 방문 배열 초기화
        visited = new boolean[n + 1];

        // 3. 간선(친구 관계) 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[u].add(v);
            graph[v].add(u);
        }

        // 4. 1번 친구부터 BFS 탐색 시작 및 결과 출력
        int result = bfs(1);

        System.out.println(result);
    }

    // BFS 탐색을 수행하는 함수 (재귀가 아닌 Queue 사용)
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 설정
        queue.offer(start);
        visited[start] = true;

        int count = 0; // 소문을 듣게 된 사람 수

        // 큐가 빌 때까지(더 이상 연결된 친구가 없을 때까지) 반복
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++; // 큐에서 꺼낼 때마다 카운트 증가

            // 현재 친구와 연결된 다른 친구들 확인
            for (int next : graph[current]) {
                // 아직 방문하지 않은(소문을 듣지 못한) 친구라면
                if (!visited[next]) {
                    visited[next] = true; // 방문 처리 (중복 큐 삽입 방지)
                    queue.offer(next);    // 다음 탐색을 위해 큐에 추가
                }
            }
        }

        return count;
    }
}