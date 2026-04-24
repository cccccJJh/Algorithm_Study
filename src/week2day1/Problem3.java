package week2day1;
import java.util.*;
/*
Problem 3: 가장 먼 노드
링크: https://school.programmers.co.kr/learn/courses/30/lessons/49189
난이도: 🔴 Lv.3
주제: 다익스트라, BFS, 그래프
문제: 1번 노드에서 모든 다른 노드까지의 최단 거리를 구한 후, 가장 먼 노드까지의 거리를 반환하세요.
n = 6, edge = [[3,6],[4,3],[3,2],[1,3],[1,2],[2,4],[5,2]]
→ 3 (거리가 3인 노드들이 있음)
핵심:

BFS로 각 노드까지의 최단 거리 계산
거리를 레벨별로 관리
최댓값 찾기
 */
public class Problem3 {

    public static void main(String[] args) {
        Problem3 sol = new Problem3();
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(sol.solution(n, vertex));
    }

    public int solution(int n, int[][] vertex) {
        // 인접 리스트 초기화.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        //간선 등록(양방향)
        for (int[] v : vertex) {
            graph.get(v[0]).add(v[1]); // a -> b
            graph.get(v[1]).add(v[0]); // b -> a
        }

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        // 시작점 예약
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int cur = queue.remove();
            System.out.println("=====================================================\n");
            System.out.println("[방문] 노드 " + cur + " (dist=" + dist[cur] + ")");

            // 다음 노드 예약
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[cur] + 1; // 거리 기록 (부모 거리 + 1)
                }
            }
        }


        // 최대 거리 탐색
        int maxDist = 0;
        for (int i = 2; i <= n; i++) maxDist = Math.max(maxDist, dist[i]);

        int count = 0;
        for (int i = 2; i <= n; i++) if (dist[i] == maxDist) count++;

        return count;
    }
}
