package week3day2;

import java.util.ArrayList;

/*
### Problem 2: 올바른 괄호
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/12909
**난이도**: 🟡 **Lv.2**
**주제**: Stack, 문자열 검증

**문제**: 괄호의 짝이 올바르게 맞으면 true, 아니면 false를 반환하세요.

```
s = "()()"
→ true

s = ")()())"
→ false
```

**핵심**:
- Stack 또는 카운터로 괄호 개수 추적
- 열린 괄호는 증가, 닫힌 괄호는 감소
- 언제든 음수가 되면 false
 */
public class Problem2 {
    public static ArrayList<String> allPaths = new ArrayList<>();

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        String s = "())()";
        System.out.println(sol.solution(s));
    }

    boolean solution(String s) {
        int count = 0;

        for(int i = 0; i < s.length() ; i++){
            System.out.println(i);
            count += s.charAt(i) == '(' ? 1 : -1 ;

            if(count<0){
                return false;
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return count == 0 ;
    }


}
