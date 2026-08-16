package programmers.lv2.p12900;

// https://school.programmers.co.kr/learn/courses/30/lessons/12900

public class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;

        if (n == 1) {
            return 1;
        }

        long previousPrevious = 1;
        long previous = 2;

        for (int i = 3; i <= n; i++) {
            long current = (previousPrevious + previous) % MOD;

            previousPrevious = previous;
            previous = current;
        }

        return (int) previous;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 4;

        int result = solution.solution(n);

        System.out.println(result); // 5
    }
}