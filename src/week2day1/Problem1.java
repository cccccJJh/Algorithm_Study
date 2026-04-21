package week2day1;
/*

Problem 1: 최댓값과 최솟값
링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939
난이도: 🟢 Lv.1
주제: 기본 알고리즘, 최댓값/최솟값
문제: 공백으로 구분된 숫자 문자열이 주어질 때, 최댓값과 최솟값을 "최솟값 최댓값" 형식으로 반환하세요.
입력: "1 2 -3 0"
출력: "-3 2"
핵심: 문자열 파싱, 정렬 또는 루프로 min/max 찾기
 */

import java.util.Arrays;

public class Problem1 {

    public static void main(String[] args) {

        Problem1 sol = new Problem1();
        System.out.println(sol.solution("1 2 3 4"));

    }

    public String solution(String s) {
        String answer = "";

        String[] arryS = s.split(" ");
        int min = Integer.parseInt(arryS[0]);
        int max = Integer.parseInt(arryS[0]);


        for (int i = 0; i < arryS.length; i++) {
            int num = Integer.parseInt(arryS[i]);
            if (num < min) min = num;
            if (num > max) max = num;
        }
        answer = min + " " + max;
        return answer;
    }
}
