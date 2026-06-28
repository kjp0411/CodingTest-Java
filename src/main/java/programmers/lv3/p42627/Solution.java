package programmers.lv3.p42627;

// https://school.programmers.co.kr/learn/courses/30/lessons/42627

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;
        int index = 0;
        int totalTime = 0;
        int count = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] current = pq.poll();

                time += current[1];
                totalTime += time - current[0];
                count++;
            }
        }

        return totalTime / jobs.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] jobs1 = {
            {0, 3},
            {1, 9},
            {3, 5}
        };

        int result1 = solution.solution(jobs1);

        System.out.println(result1); // 8
    }
}