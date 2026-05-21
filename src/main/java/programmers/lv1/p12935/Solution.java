package programmers.lv1.p12935;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12935

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != min) {
                answer[index] = arr[i];
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.solution(new int[]{4, 3, 2, 1});

        System.out.println(Arrays.toString(result));
    }
}