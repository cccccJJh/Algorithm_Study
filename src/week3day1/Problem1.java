package week3day1;
/*
### Problem 1: 두 정수 사이의 합
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/12912
**난이도**: 🟢 **Lv.1**
**주제**: 수학, 루프

**문제**: a와 b 사이의 모든 정수를 더한 값을 반환하세요.

```
a = 3, b = 5
→ 12 (3+4+5)
```

**핵심**: 등차수열의 합 공식 또는 루프로 계산
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int a = 3;
        int b = 5;
        System.out.println(sol.solution(a,b));
    }


    public long solution(int a, int b) {
        long answer = 0;
        if( a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        for(int i = a; i <= b ; i++){
            answer += i;
        }
        return answer;
    }
}
