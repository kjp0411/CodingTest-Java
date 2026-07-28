package programmers.lv2.p12913;

// https://school.programmers.co.kr/learn/courses/30/lessons/12913

public class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];

        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        max = Math.max(max, dp[i - 1][k]);
                    }
                }

                dp[i][j] = land[i][j] + max;
            }
        }

        for (int j = 0; j < 4; j++) {
            if (dp[land.length - 1][j] > answer) {
                answer = dp[land.length - 1][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] land = {
            {1, 2, 3, 5},
            {5, 6, 7, 8},
            {4, 3, 2, 1}
        };

        int result = solution.solution(land);

        System.out.println(result); // 16

    }
}