package week4day1;

import java.util.Arrays;

/*
### Problem 1: 가운데 글자 가져오기
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/12903
**난이도**: 🟢 **Lv.1**
**주제**: 문자열

**문제**: 단어 s의 가운데 글자를 반환하세요. (짝수면 가운데 2개)

```
s = "abcde"
→ "c"

s = "qwer"
→ "we"
```

**핵심**: 문자열 길이, 홀짝 판단
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        String st = "abcde";
        System.out.println(sol.solution(st));
        System.out.println(sol.solution("abcd"));
    }


    public String solution(String s) {
        String answer = "";
        int len = s.length();

        if (len % 2 == 0){ // 2로 나눈 나머지가 0이면 짝수
            // 짝수일 때는 가운데 두 글자 추출
            answer = s.substring(len/2 - 1, len/2 +1);

        }else {
            // 홀수일 때는 가운데 한 글자 추출
            answer = s.substring(len/2,  len/2+1);
        }

        return answer;
    }
}
