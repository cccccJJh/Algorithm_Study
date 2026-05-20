package week3day2;

import java.util.Arrays;

/*
## 🟡 회차 3-2 (Week 3, Day 2)

### Problem 1: 평균 구하기
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/12944
**난이도**: 🟢 **Lv.1**
**주제**: 배열, 기본 연산

**문제**: 배열의 평균을 구하여 실수로 반환하세요.

```
입력: [1, 2, 3, 4]
출력: 2.5
```

**핵심**: 합계 구하기, 길이로 나누기
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int[] arr = {1,2,3,4};
        System.out.println(sol.solution(arr));
    }


    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for(int cur : arr){
            sum += cur;
        }
        answer = (double) sum / arr.length;
        System.out.println(answer);
        return (double) Arrays.stream(arr).average().orElse(0.0);
    }
}
