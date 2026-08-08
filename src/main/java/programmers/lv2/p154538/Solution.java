package programmers.lv2.p154538;

// https://school.programmers.co.kr/learn/courses/30/lessons/154538

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[y + 1];

        Arrays.fill(distance, -1);

        queue.offer(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == y) {
                return distance[current];
            }

            int[] nextNumbers = {
                current + n,
                current * 2,
                current * 3
            };

            for (int next : nextNumbers) {
                if (next <= y && distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.solution(10, 40, 5);
        int result2 = solution.solution(10, 40, 30);
        int result3 = solution.solution(2, 5, 4);

        System.out.println(result1); // 2
        System.out.println(result2); // 1
        System.out.println(result3); // -1
    }
}