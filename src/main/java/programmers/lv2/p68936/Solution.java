package programmers.lv2.p68936;

// https://school.programmers.co.kr/learn/courses/30/lessons/68936

import java.util.Arrays;

public class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        compress(arr, 0, 0, arr.length, answer);

        return answer;
    }

    private void compress(
        int[][] arr,
        int startRow,
        int startColumn,
        int size,
        int[] answer
    ) {
        if (isSameNumber(
            arr,
            startRow,
            startColumn,
            size
        )) {
            int number = arr[startRow][startColumn];
            answer[number]++;
            return;
        }

        int half = size / 2;

        compress(
            arr,
            startRow,
            startColumn,
            half,
            answer
        );

        compress(
            arr,
            startRow,
            startColumn + half,
            half,
            answer
        );

        compress(
            arr,
            startRow + half,
            startColumn,
            half,
            answer
        );

        compress(
            arr,
            startRow + half,
            startColumn + half,
            half,
            answer
        );
    }

    private boolean isSameNumber(
        int[][] arr,
        int startRow,
        int startColumn,
        int size
    ) {
        int firstNumber = arr[startRow][startColumn];

        for (int row = startRow; row < startRow + size; row++) {
            for (
                int column = startColumn;
                column < startColumn + size;
                column++
            ) {
                if (arr[row][column] != firstNumber) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr1 = {
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };

        int[][] arr2 = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 1, 1, 1}
        };

        int[] result1 = solution.solution(arr1);
        int[] result2 = solution.solution(arr2);

        System.out.println(Arrays.toString(result1)); // [4, 9]
        System.out.println(Arrays.toString(result2)); // [10, 15]
    }
}