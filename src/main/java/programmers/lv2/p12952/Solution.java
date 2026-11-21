package programmers.lv2.p12952;

// https://school.programmers.co.kr/learn/courses/30/lessons/12952

public class Solution {

    public int solution(int n) {
        int[] queens = new int[n];

        return dfs(0, n, queens);
    }

    private int dfs(int row, int n, int[] queens) {
        if (row == n) {
            return 1;
        }

        int count = 0;

        for (int column = 0; column < n; column++) {
            if (isValid(row, column, queens)) {
                queens[row] = column;
                count += dfs(row + 1, n, queens);
            }
        }

        return count;
    }

    private boolean isValid(int row, int column, int[] queens) {
        for (int previousRow = 0; previousRow < row; previousRow++) {
            int previousColumn = queens[previousRow];

            if (previousColumn == column) {
                return false;
            }

            if (Math.abs(previousRow - row)
                    == Math.abs(previousColumn - column)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 4;
        int result = solution.solution(n);

        System.out.println(result); // 2
    }
}