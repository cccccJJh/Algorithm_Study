package week3day2;
/*
### Problem 3: 디스크 컨트롤러
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/42627
**난이도**: 🔴 **Lv.3**
**주제**: 우선순위 큐, 스케줄링

**문제**: 작업이 요청될 때마다 대기 시간을 최소화하도록 스케줄링하세요.

```
jobs = [[0, 3], [1, 9], [2, 6]]
→ 9 (평균 대기 시간)
```

**핵심**:
- PriorityQueue로 최소 작업 시간 선택 (SJF)
- 현재 시간 기준으로 가능한 작업 중 선택
 */
public class Problem3 {

    public static void main(String[] args) {
        Problem3 sol = new Problem3();
        int[][] jobs = {{0,3}, {1,9}, {3,5}};
        System.out.println(sol.solution(jobs)); // return 8
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        return answer;
    }
}
