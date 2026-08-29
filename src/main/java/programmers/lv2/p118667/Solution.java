package programmers.lv2.p118667;

// https://school.programmers.co.kr/learn/courses/30/lessons/118667

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> firstQueue = new ArrayDeque<>();
        Queue<Integer> secondQueue = new ArrayDeque<>();

        long firstSum = 0;
        long totalSum = 0;

        for (int number : queue1) {
            firstQueue.offer(number);
            firstSum += number;
            totalSum += number;
        }

        for (int number : queue2) {
            secondQueue.offer(number);
            totalSum += number;
        }

        if (totalSum % 2 != 0) {
            return -1;
        }

        long target = totalSum / 2;
        int operationCount = 0;
        int maximumOperations = queue1.length * 4;

        while (operationCount <= maximumOperations) {
            if (firstSum == target) {
                return operationCount;
            }

            if (operationCount == maximumOperations) {
                break;
            }

            if (firstSum > target) {
                int number = firstQueue.poll();

                firstSum -= number;
                secondQueue.offer(number);
            } else {
                int number = secondQueue.poll();

                firstSum += number;
                firstQueue.offer(number);
            }

            operationCount++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int result = solution.solution(queue1, queue2);

        System.out.println(result); // 2
    }
}