package programmers.lv2.p42584;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()
                && prices[stack.peek()] > prices[i]) {

                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};

        int[] result = solution.solution(prices);

        System.out.println(Arrays.toString(result)); // [4, 3, 1, 1, 0]
    }
}