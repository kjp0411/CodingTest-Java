package programmers.lv3.p43105;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105

public class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int row = 1; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0) {
                    dp[row][col] = dp[row-1][col] + triangle[row][col];
                } else if (col == row) {
                    dp[row][col] = dp[row-1][col-1] + triangle[row][col];
                } else {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row-1][col-1]) + triangle[row][col];
                }
            }
        }

        int result = 0;

        for (int col = 0; col < n; col++) {
            result = Math.max(result, dp[n - 1][col]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] triangle1 = {
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        };

        int result1 = solution.solution(triangle1);

        System.out.println(result1); // 30
    }
}