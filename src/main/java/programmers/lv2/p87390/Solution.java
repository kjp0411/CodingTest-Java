package programmers.lv2.p87390;

// https://school.programmers.co.kr/learn/courses/30/lessons/87390

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];

        for (long index = left; index <= right; index++) {
            long row = index / n;
            long col = index % n;

            result[(int) (index - left)] = (int) Math.max(row, col) + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        long left1 = 2;
        long right1 = 5;
        int[] result1 = solution.solution(n1, left1, right1);

        int n2 = 4;
        long left2 = 7;
        long right2 = 14;
        int[] result2 = solution.solution(n2, left2, right2);

        System.out.println(Arrays.toString(result1)); // [3, 2, 2, 3]
        System.out.println(Arrays.toString(result2)); // [4, 3, 3, 4, 4, 4, 4, 4]
    }
}