package programmers.lv2.p81302;

// https://school.programmers.co.kr/learn/courses/30/lessons/81302

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int index = 0; index < places.length; index++) {
            answer[index] = isValidRoom(places[index]) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValidRoom(String[] room) {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length(); col++) {
                if (room[row].charAt(col) != 'P') {
                    continue;
                }

                if (!checkDistance(room, row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkDistance(String[] room, int startRow, int startCol) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int distance = current[2];

            if (distance == 2) {
                continue;
            }

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + ROW_DIRECTIONS[direction];
                int nextCol = col + COLUMN_DIRECTIONS[direction];

                if (nextRow < 0 || nextRow >= 5
                        || nextCol < 0 || nextCol >= 5) {
                    continue;
                }

                if (visited[nextRow][nextCol]) {
                    continue;
                }

                char next = room[nextRow].charAt(nextCol);

                if (next == 'X') {
                    continue;
                }

                if (next == 'P') {
                    return false;
                }

                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol, distance + 1});
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution.solution(places);

        System.out.println(Arrays.toString(result)); // [1, 0, 1, 1, 1]
    }
}