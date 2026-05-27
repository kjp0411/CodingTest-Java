package programmers.lv2.p12941;

// https://school.programmers.co.kr/learn/courses/30/lessons/12941

import java.util.Arrays;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.solution(
            new int[]{1, 4, 2},
            new int[]{5, 4, 4}
        );

        int result2 = solution.solution(
            new int[]{1, 2},
            new int[]{3, 4}
        );

        System.out.println(result1); // 29
        System.out.println(result2); // 10
    }
}