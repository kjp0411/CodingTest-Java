package programmers.lv2.p159993;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int[] start = findPosition(maps, 'S');
        int[] lever = findPosition(maps, 'L');
        int[] exit = findPosition(maps, 'E');

        int distanceToLever = findShortestDistance(
                maps,
                start[0],
                start[1],
                lever[0],
                lever[1]
        );

        if (distanceToLever == -1) {
            return -1;
        }

        int distanceToExit = findShortestDistance(
                maps,
                lever[0],
                lever[1],
                exit[0],
                exit[1]
        );

        if (distanceToExit == -1) {
            return -1;
        }

        return distanceToLever + distanceToExit;
    }

    private int[] findPosition(String[] maps, char target) {
        for (int row = 0; row < maps.length; row++) {
            for (int column = 0; column < maps[row].length(); column++) {
                if (maps[row].charAt(column) == target) {
                    return new int[]{row, column};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private int findShortestDistance(
            String[] maps,
            int startRow,
            int startColumn,
            int targetRow,
            int targetColumn
    ) {
        int rowCount = maps.length;
        int columnCount = maps[0].length();

        boolean[][] visited = new boolean[rowCount][columnCount];
        Queue<Position> queue = new ArrayDeque<>();

        queue.offer(new Position(startRow, startColumn, 0));
        visited[startRow][startColumn] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.row == targetRow
                    && current.column == targetColumn) {

                return current.distance;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextRow =
                        current.row + ROW_DIRECTIONS[direction];

                int nextColumn =
                        current.column + COLUMN_DIRECTIONS[direction];

                if (nextRow < 0
                        || nextRow >= rowCount
                        || nextColumn < 0
                        || nextColumn >= columnCount) {

                    continue;
                }

                if (visited[nextRow][nextColumn]
                        || maps[nextRow].charAt(nextColumn) == 'X') {

                    continue;
                }

                visited[nextRow][nextColumn] = true;

                queue.offer(new Position(
                        nextRow,
                        nextColumn,
                        current.distance + 1
                ));
            }
        }

        return -1;
    }

    private static class Position {
        private final int row;
        private final int column;
        private final int distance;

        private Position(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] maps1 = {
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
        };

        String[] maps2 = {
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"
        };

        System.out.println(solution.solution(maps1)); // 16
        System.out.println(solution.solution(maps2)); // -1
    }
}