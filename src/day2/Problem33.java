package day2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem33 {
    /*

  ### Problem 3: 단어 변환
  **링크**: https://school.programmers.co.kr/learn/courses/30/lessons/43163
  **난이도**: 🔴 **Lv.3**
  **주제**: BFS, 그래프 구축, 최단 경로

  **문제**: begin에서 target으로 변환하는데, words의 단어를 거쳐 한 글자씩만 변환 가능합니다. 최소 변환 횟수를 구하세요.

  ```
  begin = "hit", target = "cog", words = ["hot","dot","dog","lot","log","cog"]
  → 5
  경로: hit → hot → dot → dog → cog
  ```

  **핵심**:
  - 한 글자 차이 나는 단어들을 간선으로 연결 (그래프 구축)
  - BFS로 최단 경로 찾기
  - 그래프 구축 방법이 핵심
   */
    public int solution(String begin, String target, String[] words) {
        //Queue<Node> queue = new LinkedList<>();
        Queue<String> wordQueue  = new LinkedList<>();  // 단어 저장
        Queue<Integer> countQueue = new LinkedList<>();  // 횟수 저장
        boolean[] visited = new boolean[words.length];

        //queue.offer(new Node(begin, 0)); // 현재 단어와 이동 횟수 저장
        wordQueue.offer(begin);   // 시작 단어 삽입
        countQueue.offer(0);      // 시작 횟수 = 0

        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.poll();
            int currCnt = countQueue.poll();

            // 목표 도달 시 즉시 반환
            if (currWord.equals(target)) return currCnt;

            // words 배열 전체를 보면서 "한 글자 차이" 단어 탐색
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isDiffByOne(currWord, words[i])) {
                    visited[i] = true; //방문처리
                    //queue.offer(new Node(words[i], curr.count + 1));
                    wordQueue.offer(words[i]); // 다음 단어 큐에 추가
                    countQueue.offer(currCnt + 1); //횟수 +1
                }
            }
        }

        return 0; // 변환할 수 없는 경우
    }

    // 단어와 단계를 묶어줄 간단한 클래스
    class Node {
        String word;
        int count;
        Node(String word, int count) { this.word = word; this.count = count; }
    }

    private boolean isDiffByOne(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) diff++;
        }
        return diff == 1; // 한 글자만 다를 때 true
    }

    public static void main(String[] args){

        Problem33 sol = new Problem33();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(sol.solution(begin, target, words));
    }
}
