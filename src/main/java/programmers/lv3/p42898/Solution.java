package programmers.lv3.p42898;

// https://school.programmers.co.kr/learn/courses/30/lessons/42898

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];

            dp[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (x == 1 && y == 1) {
                    continue;
                }

                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }

                dp[y][x] =
                    (dp[y - 1][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int m1 = 4;
        int n1 = 3;
        int[][] puddles1 = {{2, 2}};

        int result1 = solution.solution(m1, n1, puddles1);

        System.out.println(result1); // 4
    }
}