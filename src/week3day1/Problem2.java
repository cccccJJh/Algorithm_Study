package week3day1;

import java.util.*;

/*
### Problem 2: 여행 경로
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/43164
**난이도**: 🟡 **Lv.2**
**주제**: DFS, 경로 추적, 그래프

**문제**: 항공편 tickets이 주어질 때 모든 항공편을 정확히 한 번씩 이용하는 여행 경로를 구하세요.

```
tickets = [["ICN","JFK"],["HND","IAD"],["JFK","HND"]]
→ ["ICN", "JFK", "HND", "IAD"]
```

**핵심**:
- DFS로 모든 항공편 사용
- 방문한 간선 추적
- 백트래킹으로 경로 복구
 */
public class Problem2 {
    public static ArrayList<String> allPaths = new ArrayList<>();

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};

        System.out.println(sol.solution(tickets));
        System.out.println(allPaths.toString());


    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN","ICN",tickets,0,visited);
        answer = allPaths.toArray(String[]:: new);



        return answer;
    }

    public void dfs(String now, String path, String[][] tickets, int count, boolean[] visited) {

        if (count == tickets.length) {
            //allPaths.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i]) {
                if (tickets[i][0].equals(now)) {
                    visited[i] = true;
                    System.out.println("============================/n");
                    System.out.println(path);
                    System.out.println(tickets[i][0]);
                    System.out.println(tickets[i][1]);
                    allPaths.add(tickets[i][1]);
                    dfs(tickets[i][1], path + "," + tickets[i][1], tickets, count + 1, visited);
                }
            }
        }

    }
}
