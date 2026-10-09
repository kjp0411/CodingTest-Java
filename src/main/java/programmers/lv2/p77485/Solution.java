package programmers.lv2.p77485;

// https://school.programmers.co.kr/learn/courses/30/lessons/77485

import java.util.Arrays;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = createMatrix(rows, columns);
        int[] answer = new int[queries.length];

        for (int queryIndex = 0; queryIndex < queries.length; queryIndex++) {
            answer[queryIndex] = rotateBorder(matrix, queries[queryIndex]);
        }

        return answer;
    }

    private int[][] createMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = row * columns + column + 1;
            }
        }

        return matrix;
    }

    private int rotateBorder(int[][] matrix, int[] query) {
        int top = query[0] - 1;
        int left = query[1] - 1;
        int bottom = query[2] - 1;
        int right = query[3] - 1;

        int carriedValue = matrix[top][left];
        int minimumValue = carriedValue;

        // 위쪽 테두리: 왼쪽 -> 오른쪽
        for (int column = left + 1; column <= right; column++) {
            carriedValue = moveValue(
                    matrix,
                    top,
                    column,
                    carriedValue
            );

            minimumValue = Math.min(minimumValue, carriedValue);
        }

        // 오른쪽 테두리: 위쪽 -> 아래쪽
        for (int row = top + 1; row <= bottom; row++) {
            carriedValue = moveValue(
                    matrix,
                    row,
                    right,
                    carriedValue
            );

            minimumValue = Math.min(minimumValue, carriedValue);
        }

        // 아래쪽 테두리: 오른쪽 -> 왼쪽
        for (int column = right - 1; column >= left; column--) {
            carriedValue = moveValue(
                    matrix,
                    bottom,
                    column,
                    carriedValue
            );

            minimumValue = Math.min(minimumValue, carriedValue);
        }

        // 왼쪽 테두리: 아래쪽 -> 위쪽
        for (int row = bottom - 1; row >= top; row--) {
            carriedValue = moveValue(
                    matrix,
                    row,
                    left,
                    carriedValue
            );

            minimumValue = Math.min(minimumValue, carriedValue);
        }

        return minimumValue;
    }

    private int moveValue(
            int[][] matrix,
            int row,
            int column,
            int carriedValue
    ) {
        int nextValue = matrix[row][column];
        matrix[row][column] = carriedValue;

        return nextValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int rows1 = 6;
        int columns1 = 6;
        int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result1 = solution.solution(rows1, columns1, queries1);

        int rows2 = 3;
        int columns2 = 3;
        int[][] queries2 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[] result2 = solution.solution(rows2, columns2, queries2);

        int rows3 = 100;
        int columns3 = 97;
        int[][] queries3 = {{1, 1, 100, 97}};
        int[] result3 = solution.solution(rows3, columns3, queries3);

        System.out.println(Arrays.toString(result1)); // [8, 10, 25]
        System.out.println(Arrays.toString(result2)); // [1, 1, 5, 3]
        System.out.println(Arrays.toString(result3)); // [1]
    }
}