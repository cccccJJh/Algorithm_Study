package week2day2;

import java.util.*;

/*
### Problem 2: 프린터
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/42587
**난이도**: 🟡 **Lv.2**
**주제**: Queue, 우선순위, 시뮬레이션

**문제**: 프린터 큐에서 중요도가 높은 문서부터 인쇄됩니다. location 위치의 문서가 몇 번째로 인쇄되는지 구하세요.

```
priorities = [2, 1, 3, 2], location = 2
→ 1 (위치 2의 문서(3)가 1번째 인쇄)
```

**핵심**:
- Queue + 우선순위 처리
- 각 문서의 원래 위치 추적
 */
public class Problem2 {

    public static void main(String[] args) {
        Problem2 sol = new Problem2();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(sol.solution(priorities, location));


    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length ; i++){
            queue.offer(new int[]{i, priorities[i]});
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            boolean hasHigher = false;

            for(int[] proccess: queue){
                if(proccess[1] > curr[1]) {
                    hasHigher = true;
                    break;
                }
            }
            if(hasHigher){ // 우선순위 높은게 있으면 뒤로 보냄
                queue.offer(curr);
            } else {
                answer++;
                if(curr[0] == location){
                    return answer;
                }
            }
        }

        return answer;
    }
}
