package programmers.lv3.p12971;

// https://school.programmers.co.kr/learn/courses/30/lessons/12971

public class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        }
        int case1 = getMax(sticker, 0, sticker.length - 2);
        int case2 = getMax(sticker, 1, sticker.length - 1);

        return Math.max(case1, case2);
    }

    private int getMax(int[] sticker, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length];

        dp[0] = sticker[start];

        if (length == 1) {
            return dp[0];
        }

        dp[1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(
                dp[i - 1],
                dp[i - 2] + sticker[start + i]
            );
        }

        return dp[length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = {1, 3, 4, 5, 4};

        int result1 = solution.solution(sticker1);
        int result2 = solution.solution(sticker2);

        System.out.println(result1); // 36
        System.out.println(result2); // 8
    }
}