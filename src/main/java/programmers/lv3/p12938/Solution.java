package programmers.lv3.p12938;

// https://school.programmers.co.kr/learn/courses/30/lessons/12938

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        int quotient = s / n;
        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = quotient;
        }

        for (int i = n - remainder; i < n; i++) {
            answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2;
        int s1 = 9;

        int n2 = 2;
        int s2 = 1;

        int n3 = 2;
        int s3 = 8;

        int[] result1 = solution.solution(n1, s1);
        int[] result2 = solution.solution(n2, s2);
        int[] result3 = solution.solution(n3, s3);

        System.out.println(Arrays.toString(result1)); // [4, 5]
        System.out.println(Arrays.toString(result2)); // [-1]
        System.out.println(Arrays.toString(result3)); // [4, 4]
    }
}