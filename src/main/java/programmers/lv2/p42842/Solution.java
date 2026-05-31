package programmers.lv2.p42842;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842

import java.util.Arrays;

public class Solution {
    public int[] solution(int brown, int yellow) {

        for (int height = 1; height <= Math.sqrt(yellow); height++) {
            if (yellow % height == 0) {
                int width = yellow / height;

                int carpetWidth = width + 2;
                int carpetHeight = height + 2;

                int brownCount = carpetWidth * carpetHeight - yellow;

                if (brownCount == brown) {
                    return new int[]{carpetWidth, carpetHeight};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result1 = solution.solution(10, 2);
        int[] result2 = solution.solution(8, 1);
        int[] result3 = solution.solution(24, 24);

        System.out.println(Arrays.toString(result1)); // [4, 3]
        System.out.println(Arrays.toString(result2)); // [3, 3]
        System.out.println(Arrays.toString(result3)); // [8, 6]
    }
}