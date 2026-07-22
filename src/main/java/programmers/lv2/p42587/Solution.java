package programmers.lv2.p42587;

// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int printNumber = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            boolean hasHigherPriority = false;

            for (int[] document : queue) {
                if (document[1] > current[1]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.offer(current);
            } else {
                printNumber++;

                if (current[0] == location) {
                    return printNumber;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int result1 = solution.solution(priorities1, location1);

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int result2 = solution.solution(priorities2, location2);

        System.out.println(result1); // 1
        System.out.println(result2); // 5
    }
}