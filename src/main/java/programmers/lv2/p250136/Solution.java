package programmers.lv2.p250136;

// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int rows = land.length;
        int columns = land[0].length;

        boolean[][] visited = new boolean[rows][columns];
        int[] oilAmounts = new int[columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (land[row][column] == 1 && !visited[row][column]) {
                    exploreOil(land, visited, oilAmounts, row, column);
                }
            }
        }

        int answer = 0;

        for (int amount : oilAmounts) {
            answer = Math.max(answer, amount);
        }

        return answer;
    }

    private void exploreOil(
            int[][] land,
            boolean[][] visited,
            int[] oilAmounts,
            int startRow,
            int startColumn
    ) {
        int rows = land.length;
        int columns = land[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] includedColumns = new boolean[columns];

        queue.offer(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;

        int oilSize = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int column = current[1];

            oilSize++;
            includedColumns[column] = true;

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + ROW_DIRECTIONS[direction];
                int nextColumn = column + COLUMN_DIRECTIONS[direction];

                if (nextRow < 0 || nextRow >= rows
                        || nextColumn < 0 || nextColumn >= columns) {
                    continue;
                }

                if (visited[nextRow][nextColumn]
                        || land[nextRow][nextColumn] == 0) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                queue.offer(new int[]{nextRow, nextColumn});
            }
        }

        for (int column = 0; column < columns; column++) {
            if (includedColumns[column]) {
                oilAmounts[column] += oilSize;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] land1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int result1 = solution.solution(land1);

        int[][] land2 = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        int result2 = solution.solution(land2);

        System.out.println(result1); // 9
        System.out.println(result2); // 16
    }
}