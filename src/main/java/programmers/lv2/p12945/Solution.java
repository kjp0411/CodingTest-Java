package programmers.lv2.p12945;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945

public class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int n2 = 5;

        int result1 = solution.solution(n1);
        int result2 = solution.solution(n2);

        System.out.println(result1); // 2
        System.out.println(result2); // 5
    }
}