package week2day1;
/*
Problem 2: 타겟 넘버
링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165
난이도: 🟡 Lv.2
주제: DFS, 재귀, 모든 경로 탐색
문제: 배열 numbers의 각 숫자 앞에 +, - 중 하나를 선택해서 target을 만드는 경우의 수를 구하세요.
numbers = [1,1,1,1,1], target = 3
→ 5 (여러 방법이 있음)
핵심:

재귀로 모든 부호 조합 탐색
DFS의 기본 형태
시간복잡도: O(2^n)
 */
public class Problem2 {

    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 5;
        System.out.println(sol.solution(nums, target));
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        return answer;
    }

}
