package programmers.lv2.p154539;

// https://school.programmers.co.kr/learn/courses/30/lessons/154539

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = -1;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                result[index] = numbers[i];
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers1 = {2, 3, 3, 5};
        int[] numbers2 = {9, 1, 5, 3, 6, 2};

        int[] result1 = solution.solution(numbers1);
        int[] result2 = solution.solution(numbers2);

        System.out.println(Arrays.toString(result1)); // [3, 5, 5, -1]
        System.out.println(Arrays.toString(result2)); // [-1, 5, 6, 6, -1, -1]
    }
}