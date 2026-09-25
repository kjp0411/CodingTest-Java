package programmers.lv2.p169199;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int solution(String[] board) {
        int rowCount = board.length;
        int columnCount = board[0].length();

        int[] start = findPosition(board, 'R');

        boolean[][] visited = new boolean[rowCount][columnCount];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentRow = current[0];
            int currentColumn = current[1];
            int moveCount = current[2];

            if (board[currentRow].charAt(currentColumn) == 'G') {
                return moveCount;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = currentRow;
                int nextColumn = currentColumn;

                while (canMove(
                        board,
                        nextRow + ROW_DIRECTIONS[direction],
                        nextColumn + COLUMN_DIRECTIONS[direction]
                )) {
                    nextRow += ROW_DIRECTIONS[direction];
                    nextColumn += COLUMN_DIRECTIONS[direction];
                }

                if (!visited[nextRow][nextColumn]) {
                    visited[nextRow][nextColumn] = true;
                    queue.offer(new int[]{
                            nextRow,
                            nextColumn,
                            moveCount + 1
                    });
                }
            }
        }

        return -1;
    }

    private int[] findPosition(String[] board, char target) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length(); column++) {
                if (board[row].charAt(column) == target) {
                    return new int[]{row, column};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private boolean canMove(String[] board, int row, int column) {
        return row >= 0
                && row < board.length
                && column >= 0
                && column < board[0].length()
                && board[row].charAt(column) != 'D';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] board1 = {
                "...D..R",
                ".D.G...",
                "....D.D",
                "D....D.",
                "..D...."
        };

        String[] board2 = {
                ".D.R",
                "....",
                ".G..",
                "...D"
        };

        System.out.println(solution.solution(board1)); // 7
        System.out.println(solution.solution(board2)); // -1
    }
}