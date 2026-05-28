package programmers.lv2.p70129;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {
        int convertCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            String removeZeroS = s.replace("0", "");

            zeroCount += s.length() - removeZeroS.length();

            int length = removeZeroS.length();

            s = Integer.toBinaryString(length);

            convertCount++;
        }
        return new int[]{convertCount, zeroCount};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        int[] result1 = solution.solution(s1);
        int[] result2 = solution.solution(s2);
        int[] result3 = solution.solution(s3);

        System.out.println(Arrays.toString(result1)); // [3, 8]
        System.out.println(Arrays.toString(result2)); // [3, 3]
        System.out.println(Arrays.toString(result3)); // [4, 1]
    }
}