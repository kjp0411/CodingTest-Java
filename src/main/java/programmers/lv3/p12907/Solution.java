package programmers.lv3.p12907;

// https://school.programmers.co.kr/learn/courses/30/lessons/12907

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int coin : money) {
            for (int amount = coin; amount <= n; amount++) {
                dp[amount] = (dp[amount] + dp[amount - coin]) % MOD;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5;

        int[] money1 = {1, 2, 5};

        int result1 = solution.solution(n1, money1);

        System.out.println(result1); // 4
    }
}