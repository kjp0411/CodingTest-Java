package programmers.lv2.p68645;

// https://school.programmers.co.kr/learn/courses/30/lessons/68645

import java.util.Arrays;

public class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int row = -1;
        int column = 0;
        int number = 1;

        for (int direction = 0; direction < n; direction++) {
            int moveCount = n - direction;

            for (int move = 0; move < moveCount; move++) {
                if (direction % 3 == 0) {
                    // 아래로 이동
                    row++;
                } else if (direction % 3 == 1) {
                    // 오른쪽으로 이동
                    column++;
                } else {
                    // 왼쪽 위 대각선으로 이동
                    row--;
                    column--;
                }

                triangle[row][column] = number;
                number++;
            }
        }

        int[] answer = new int[n * (n + 1) / 2];
        int index = 0;

        for (int currentRow = 0; currentRow < n; currentRow++) {
            for (
                    int currentColumn = 0;
                    currentColumn <= currentRow;
                    currentColumn++
            ) {
                answer[index] = triangle[currentRow][currentColumn];
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result1 = solution.solution(4);
        int[] result2 = solution.solution(5);
        int[] result3 = solution.solution(6);

        System.out.println(Arrays.toString(result1));   // [1, 2, 9, 3, 10, 8, 4, 5, 6, 7]

        System.out.println(Arrays.toString(result2));   // [1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9]

        System.out.println(Arrays.toString(result3));   // [1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11]
    }
}