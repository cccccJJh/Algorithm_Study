package day1;

/*

### Problem 3: 네트워크
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/43162
**난이도**: 🔴 **Lv.3**
**주제**: 그래프, DFS/BFS, 연결 컴포넌트

**문제**: 컴퓨터 n개가 있고 인접행렬 computers가 주어질 때, 네트워크의 개수를 반환하세요.

```
n = 3,
computers =
****** 0, 1, 2
0 ==  [1, 1, 0],
1 ==  [1, 1, 0],
2 ==  [0, 0, 1]
→ 2 (네트워크 2개: {0,1}, {2})
```

**핵심**:
- 인접행렬을 그래프로 해석
- DFS/BFS로 연결된 컴포넌트 개수 세기
- visited 배열로 중복 방지

 */

import java.util.*;

class Problem3 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                answer += 1;
                bfs(i, n, computers, visited);
            }
        }

        return answer;
    }

    public void bfs(int start, int n, int[][] computers, boolean[] visited){

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for (int nxt =0; nxt < n; nxt++){

                if(computers[curr][nxt] == 1 && !visited[nxt]){
                    queue.offer(nxt);
                    visited[nxt] = true;

                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 1. 백준 문제에 맞게 직접 입력을 받는다
        int a = sc.nextInt();
        int b = sc.nextInt();

        Problem3 sol = new Problem3();
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};

        System.out.println("최종결과 : " + sol.solution(n, computers));
        //return 1;
    }
}