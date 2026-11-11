package programmers.lv2.p388353;

// https://school.programmers.co.kr/learn/courses/30/lessons/388353

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COLUMN_DIRECTIONS = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int rows = storage.length;
        int columns = storage[0].length();

        char[][] warehouse = new char[rows + 2][columns + 2];

        // 창고 바깥에 빈 공간을 한 겹 추가
        for (int row = 0; row < rows + 2; row++) {
            for (int column = 0; column < columns + 2; column++) {
                warehouse[row][column] = '.';
            }
        }

        // 실제 컨테이너 배치
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                warehouse[row + 1][column + 1] =
                        storage[row].charAt(column);
            }
        }

        // 출고 요청을 순서대로 처리
        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                removeByCrane(warehouse, target);
            } else {
                removeByForklift(warehouse, target);
            }
        }

        // 남아 있는 컨테이너 개수 계산
        int answer = 0;

        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                if (warehouse[row][column] != '.') {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void removeByCrane(char[][] warehouse, char target) {
        for (int row = 1; row < warehouse.length - 1; row++) {
            for (int column = 1;
                 column < warehouse[0].length - 1;
                 column++) {

                if (warehouse[row][column] == target) {
                    warehouse[row][column] = '.';
                }
            }
        }
    }

    private void removeByForklift(char[][] warehouse, char target) {
        int rows = warehouse.length;
        int columns = warehouse[0].length;

        boolean[][] visited = new boolean[rows][columns];

        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> removeList = new ArrayList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int column = current[1];

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = row + ROW_DIRECTIONS[direction];
                int nextColumn = column + COLUMN_DIRECTIONS[direction];

                if (nextRow < 0 || nextRow >= rows ||
                        nextColumn < 0 || nextColumn >= columns) {
                    continue;
                }

                if (visited[nextRow][nextColumn]) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;

                if (warehouse[nextRow][nextColumn] == '.') {
                    queue.offer(new int[]{nextRow, nextColumn});
                } else if (warehouse[nextRow][nextColumn] == target) {
                    removeList.add(new int[]{nextRow, nextColumn});
                }
            }
        }

        // BFS 종료 후 제거해야 연쇄 출고를 방지할 수 있음
        for (int[] position : removeList) {
            warehouse[position[0]][position[1]] = '.';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] storage1 = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests1 = {"A", "BB", "A"};
        int result1 = solution.solution(storage1, requests1);

        String[] storage2 = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests2 = {"C", "B", "B", "B", "B", "H"};
        int result2 = solution.solution(storage2, requests2);

        System.out.println(result1); // 11
        System.out.println(result2); // 4
    }
}