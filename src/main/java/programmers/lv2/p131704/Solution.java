package programmers.lv2.p131704;

// https://school.programmers.co.kr/learn/courses/30/lessons/131704

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();

        int nextBox = 1;
        int answer = 0;

        for (int target : order) {
            while (nextBox <= order.length && nextBox <= target) {
                stack.push(nextBox);
                nextBox++;
            }
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] order1 = {4, 3, 1, 2, 5};
        int result1 = solution.solution(order1);

        int[] order2 = {5, 4, 3, 2, 1};
        int result2 = solution.solution(order2);

        System.out.println(result1); // 2
        System.out.println(result2); // 5
    }
}