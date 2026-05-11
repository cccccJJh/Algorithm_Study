package week2day2;
/*
### Problem 1: 없는 숫자 더하기
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/86051
**난이도**: 🟢 **Lv.1**
**주제**: 배열, 집합

**문제**: 0부터 9까지의 숫자 중 numbers에 없는 숫자들의 합을 반환하세요.

```
입력: [1,2,3,4,6,7,8,0]
출력: 14 (5 + 9)
```

**핵심**: Set 사용 또는 boolean[] 플래그로 존재 여부 확인
 */
public class Problem1 {
    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(sol.solution(numbers));
    }


    public int solution(int[] numbers) {
        int answer = 0;
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        boolean[] isExists = new boolean[nums.length];

        for(int i = 0; i < numbers.length ; i++){
            int num = numbers[i];
            isExists[num] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isExists[i]){
                answer += i;
            }
        }
        return answer;
    }
}
