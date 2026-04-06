package day1;

import java.util.Arrays;

import static java.util.Arrays.sort;

/*
### Problem 2: 구명보트
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/42885
**난이도**: 🟡 **Lv.2**
**주제**: 그리디, 정렬, 투 포인터

**문제**: 사람들의 몸무게와 보트 무게 제한이 주어질 때, 모두를 구출하는데 필요한 최소 보트 수를 구하세요.

```
people = [70, 50, 80, 50], limit = 100
→ 3 (70+50, 80, 50)
```

**핵심**:
- 가장 무거운 사람과 가장 가벼운 사람을 짝지어보기
- 투 포인터로 효율적으로 처리
 */
public class Problem2 {
    public int solution(int[] n, int limit) {
        int answer = 0;
        Arrays.sort(n);
        System.out.println(Arrays.toString(n));

        int lightest = 0;
        int heaviest = n.length - 1;


        while (lightest <= heaviest) {

            if (lightest == heaviest){
                System.out.printf("보트 %d : %d\n", answer, n[heaviest]);
            }
            else if (n[lightest] + n[heaviest] <= limit) {
                lightest++ ;
                System.out.printf("보트 %d : %d + %d\n", answer, n[lightest], n[heaviest]);
            }else {
                System.out.printf("보트 %d : %d\n", answer, n[heaviest]);
            }

            heaviest--;
            answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int[] people = {70, 50, 80, 50};
        int limit = 120;

        System.out.println(sol.solution(people, limit));

    }
}