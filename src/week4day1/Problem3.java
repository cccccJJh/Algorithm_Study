package week4day1;

import java.util.Arrays;

/*
### Problem 3: 정수 삼각형
**링크**: https://school.programmers.co.kr/learn/courses/30/lessons/43105
**난이도**: 🔴 **Lv.3**
**주제**: DP, 경로 최적화

**문제**: 삼각형의 맨 위에서 맨 아래까지 가는 경로 중 최대 합을 구하세요.

```
triangle = [[7],[3,8],[8,1,0],[2,7,4,4],[4,5,2,6,5]]
→ 30 (7+8+1+5+9)
```

**핵심**:
- DP로 각 위치에서의 최대 합 계산
- 상향식 DP (아래에서 위로)
 */
public class Problem3 {

    public static void main(String[] args) {
        Problem3 sol = new Problem3();
        int[][] triangle = {{7}, {3,8}, {8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println("return: " + sol.solution(triangle)); // return 8
    }

    public int solution(int[][] triangle) {
        int answer = 0;


        //dp 복사본 만들기
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            dp[i] = triangle[i].clone(); // 원본 복사
            System.out.println("dp[" + i + "] = " + Arrays.toString(dp[i]));
        }

        // 상향식 DP (아래에서 위로) ....
        for(int i = triangle.length -2 ; i >= 0; i--){
            System.out.println(i + ">>>>" );
            for(int j =0; j < triangle[i].length; j++){
                int left  = dp[i + 1][j];
                int right = dp[i + 1][j + 1];
                //System.out.print(triangle[i][j] + ", ");
                //System.out.println(Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]) + "..");
                dp[i][j] = triangle[i][j] + Math.max(left, right);
                System.out.println("  dp[" + i + "][" + j + "] = "
                        + "triangle[" + i + "][" + j + "](" + triangle[i][j] + ")"
                        + " + max(" + left + ", " + right + ")"
                        + " = " + dp[i][j]);
            }

        }
        answer= dp[0][0];
        return answer;
    }
}
