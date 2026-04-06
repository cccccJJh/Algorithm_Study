package day1;

/*
## 🟢 회차 1-1 (Week 1, Day 1)

### Problem 1: 자릿수 더하기
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/120906
**난이도**: 🟢 **Lv.1**
**주제**: 기본 연산

**문제**: 양의 정수 n이 주어질 때, n의 각 자릿수를 모두 더한 값을 반환하세요.

```
입력: 930211
출력: 16 (9+3+0+2+1+1)
```

**핵심**: 숫자를 문자열로 변환하거나, 나머지 연산으로 각 자릿수 추출
 */

public class Problem1 {

    public int solution1(int n) {
        // 숫자를 문자열로 변환
        int answer = 0;

        String str = String.valueOf(n);
        for(int i= 0; i < str.length(); i++){
            answer +=  Character.getNumericValue(str.charAt(i));
        }
        return answer;
    }

    public int solution2(int n){
        int answer = 0;

        while(n>0){
            answer += n%10;
            n /= 10;
        }
        return answer;
    }

    // 테스트용 main
    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        System.out.println(sol.solution1(930211));
        System.out.println(sol.solution2(930211));
        // 16 나오면 정답!

    }
}

