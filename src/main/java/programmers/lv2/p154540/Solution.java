package programmers.lv2.p154540;

// https://school.programmers.co.kr/learn/courses/30/lessons/154540


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        int rowCount = maps.length;
        int columnCount = maps[0].length();

        boolean[][] visited = new boolean[rowCount][columnCount];
        List<Integer> islandDays = new ArrayList<>();

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (maps[row].charAt(column) == 'X' || visited[row][column]) {
                    continue;
                }

                int totalDays = exploreIsland(maps, visited, row, column);
                islandDays.add(totalDays);
            }
        }

        if (islandDays.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(islandDays);

        return islandDays.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int exploreIsland(String[] maps, boolean[][] visited,
                              int startRow, int startColumn) {
        int rowCount = maps.length;
        int columnCount = maps[0].length();

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;

        int totalDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int column = current[1];

            totalDays += maps[row].charAt(column) - '0';

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + ROW_DIRECTIONS[direction];
                int nextColumn = column + COLUMN_DIRECTIONS[direction];

                if (nextRow < 0 || nextRow >= rowCount
                        || nextColumn < 0 || nextColumn >= columnCount) {
                    continue;
                }

                if (visited[nextRow][nextColumn]
                        || maps[nextRow].charAt(nextColumn) == 'X') {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                queue.offer(new int[]{nextRow, nextColumn});
            }
        }

        return totalDays;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] maps1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] maps2 = {"XXX", "XXX", "XXX"};

        int[] result1 = solution.solution(maps1);
        int[] result2 = solution.solution(maps2);

        System.out.println(Arrays.toString(result1)); // [1, 1, 27]
        System.out.println(Arrays.toString(result2)); // [-1]
    }
}