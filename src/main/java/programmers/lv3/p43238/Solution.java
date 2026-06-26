package programmers.lv3.p43238;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238

import java.util.Arrays;

public class Solution {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long count = 0;

            for (int time : times) {
                count += mid / time;

                if (count >= n) {
                    break;
                }
            }

            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[] times = {7, 10};

        System.out.println(solution.solution(n, times)); // 28
    }
}