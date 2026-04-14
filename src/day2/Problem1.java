package day2;

public class Problem1 {
        /*
    ## 🟡 회차 1-2 (Week 1, Day 2)

    ### Problem 1: 문자열 내 p와 y의 개수
    **링크**: https://school.programmers.co.kr/learn/courses/30/lessons/12916
    **난이도**: 🟢 **Lv.1**
    **주제**: 문자열, 카운팅

    **문제**: 문자열 s에서 p(또는 P)와 y(또는 Y)의 개수가 같으면 true, 다르면 false를 반환하세요.

    ```
    입력: "pPoooyY"
    출력: true (p가 2개, y가 2개)
    ```

    **핵심**: 문자열 순회, 대소문자 처리 (toLowerCase)
     */

    boolean solution(String s) {
        boolean answer = false;
        s = s.toLowerCase();

        int pCnt= 0 ;
        int yCnt = 0 ;

        for(int i= 0; i < s.length(); i++){
            String current = String.valueOf(s.charAt(i));

            if (current.equals("p")) {
                pCnt++;
            } else if(current.equals("y")){
                yCnt++;
            }
        }

        System.out.println("P: " + pCnt +", Y:" + yCnt);
        if(pCnt == yCnt) answer = true;
        return answer;
    }

    public static void main(String[] args){
        Problem1 sol = new Problem1();

        System.out.println(sol.solution("Happy"));

    }
}
