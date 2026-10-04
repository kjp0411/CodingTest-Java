package programmers.lv2.p147354;

// https://school.programmers.co.kr/learn/courses/30/lessons/147354

import java.util.Arrays;

public class Solution {
    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        int columnIndex = col - 1;

        Arrays.sort(data, (first, second) -> {
            if (first[columnIndex] != second[columnIndex]) {
                return Integer.compare(
                        first[columnIndex],
                        second[columnIndex]
                );
            }

            return Integer.compare(second[0], first[0]);
        });

        int hashValue = 0;

        for (int rowIndex = rowBegin - 1; rowIndex < rowEnd; rowIndex++) {
            int rowNumber = rowIndex + 1;
            int remainderSum = 0;

            for (int value : data[rowIndex]) {
                remainderSum += value % rowNumber;
            }

            hashValue ^= remainderSum;
        }

        return hashValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] data1 = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col1 = 2;
        int rowBegin1 = 2;
        int rowEnd1 = 3;

        int result1 = solution.solution(data1, col1, rowBegin1, rowEnd1);

        System.out.println(result1); // 4
    }
}