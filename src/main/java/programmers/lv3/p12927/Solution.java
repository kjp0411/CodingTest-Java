package programmers.lv3.p12927;

// https://school.programmers.co.kr/learn/courses/30/lessons/12927

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0) {
            int max = pq.poll();

            if (max == 0) {
                break;
            }

            max--;

            pq.offer(max);

            n--;
        }

        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 4;
        int[] works1 = {4, 3, 3};

        int n2 = 1;
        int[] works2 = {2, 1, 2};

        int n3 = 3;
        int[] works3 = {1, 1};

        long result1 = solution.solution(n1, works1);
        long result2 = solution.solution(n2, works2);
        long result3 = solution.solution(n3, works3);

        System.out.println(result1); // 12
        System.out.println(result2); // 6
        System.out.println(result3); // 0
    }
}