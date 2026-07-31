package programmers.lv2.p42626;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (int value : scoville) {
            queue.offer((long) value);
        }

        int count = 0;

        while (queue.peek() < K) {
            if (queue.size() < 2) {
                return -1;
            }

            long first = queue.poll();
            long second = queue.poll();
            long mixed = first + second * 2;

            queue.offer(mixed);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = solution.solution(scoville, K);

        System.out.println(result); // 2
    }
}