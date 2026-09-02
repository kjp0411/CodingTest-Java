package programmers.lv2.p178870;

// https://school.programmers.co.kr/learn/courses/30/lessons/178870

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        long sum = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int length = right - left + 1;

                if (length < minimumLength) {
                    minimumLength = length;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] sequence1 = {1, 2, 3, 4, 5};
        int k1 = 7;
        int[] result1 = solution.solution(sequence1, k1);

        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int k2 = 5;
        int[] result2 = solution.solution(sequence2, k2);

        int[] sequence3 = {2, 2, 2, 2, 2};
        int k3 = 6;
        int[] result3 = solution.solution(sequence3, k3);

        System.out.println(Arrays.toString(result1)); // [2, 3]
        System.out.println(Arrays.toString(result2)); // [6, 6]
        System.out.println(Arrays.toString(result3)); // [0, 2]
    }
}