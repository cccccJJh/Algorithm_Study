package week4day1;

import java.util.PriorityQueue;

/*
### Problem 2: 더 맵게
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/42626
**난이도**: 🟡 **Lv.2**
**주제**: 우선순위 큐, PriorityQueue

**문제**: 음식들의 스코빌 지수가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만드는 최소 섞기 횟수를 구하세요.

```
scoville = [1, 2, 3, 9, 10, 12], K = 7
→ 2 (1+2*2=5, 5+3*2=11... 등으로 2번)
```

**핵심**:
- Min Heap으로 가장 맵지 않은 음식부터 처리
- PriorityQueue 적극 활용
 */
public class Problem2 {


    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(sol.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //스코빌지수 초기화
        for (int s : scoville){
            pq.add(s);
        }

        // 가장 맵지 않은 음식이 K 미만인 동안 계속 반복
        while (pq.peek() < K){
            if(pq.size() < 2){
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();

            //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
            int mixed = first + (second * 2);
            pq.add(mixed);

            answer++;
        }
        return answer;
    }
}
