package day2;

public class Problem3 {

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
        boolean[] visited = new boolean[words.length];
        int answer =  0;
        bfs(begin, target, words, visited, 0);
        return answer;
    }

    public int bfs(String current, String target, String[] words,  boolean[] visited, int index){
        int diff = 0;
        int answer = 0;
        visited[index] = true;

        for(int i = 0; i < current.length(); i++) {
            if (!visited[i]){
                visited[i] = true;
                if(current.charAt(i) != words[index].charAt(i)){
                    bfs(words[i], target, words, visited, index+1);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Problem3 sol = new Problem3();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(sol.solution(begin, target, words));
    }
}
