package programmers.lv2.p12905;

// https://school.programmers.co.kr/learn/courses/30/lessons/12905

public class Solution {
    public int solution(int[][] board) {
        int rowCount = board.length;
        int columnCount = board[0].length;
        int[][] dp = new int[rowCount + 1][columnCount + 1];
        int maximumSide = 0;

        for (int row = 1; row <= rowCount; row++) {
            for (int column = 1; column <= columnCount; column++) {
                if (board[row - 1][column - 1] == 0) {
                    continue;
                }

                dp[row][column] = Math.min(
                        dp[row - 1][column - 1],
                        Math.min(dp[row - 1][column], dp[row][column - 1])
                ) + 1;

                maximumSide = Math.max(maximumSide, dp[row][column]);
            }
        }

        return maximumSide * maximumSide;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int board1[][] = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        };

        int result1 = solution.solution(board1);

        int board2[][] = {
                {0, 0, 1, 1},
                {1, 1, 1, 1}
        };

        int result2 = solution.solution(board2);

        System.out.println(result1); // 9
        System.out.println(result2); // 4
    }
}