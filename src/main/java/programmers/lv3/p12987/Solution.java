package programmers.lv3.p12987;

// https://school.programmers.co.kr/learn/courses/30/lessons/12987

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIndex = 0;
        int bIndex = 0;
        int score = 0;

        while (aIndex < A.length && bIndex < B.length) {
            if (A[aIndex] < B[bIndex]) {
                score++;
                aIndex++;
                bIndex++;
            } else {
                bIndex++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] A1 = {5, 1, 3, 7};
        int[] B1 = {2, 2, 6, 8};

        int[] A2 = {2, 2, 2, 2};
        int[] B2 = {1, 1, 1, 1};

        int result1 = solution.solution(A1, B1);
        int result2 = solution.solution(A2, B2);

        System.out.println(result1); // 3
        System.out.println(result2); // 0
    }
}