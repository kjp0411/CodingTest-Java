package programmers.lv2.p12949;

// https://school.programmers.co.kr/learn/courses/30/lessons/12949

import java.util.Arrays;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int common = arr1[0].length;

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < common; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr1 = {
            {1, 4},
            {3, 2},
            {4, 1}
        };

        int[][] arr2 = {
            {3, 3},
            {3, 3}
        };

        int[][] result1 = solution.solution(arr1, arr2);

        int[][] arr3 = {
            {2, 3, 2},
            {4, 2, 4},
            {3, 1, 4}
        };

        int[][] arr4 = {
            {5, 4, 3},
            {2, 4, 1},
            {3, 1, 1}
        };

        int[][] result2 = solution.solution(arr3, arr4);

        System.out.println(Arrays.deepToString(result1));
        // [[15, 15], [15, 15], [15, 15]]

        System.out.println(Arrays.deepToString(result2));
        // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
    }
}