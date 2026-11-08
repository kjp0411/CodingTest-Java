package programmers.lv2.p134239;

// https://school.programmers.co.kr/learn/courses/30/lessons/134239

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);

        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }

            sequence.add(k);
        }

        int n = sequence.size() - 1;
        double[] prefixSum = new double[n + 1];

        for (int i = 0; i < n; i++) {
            double area = (sequence.get(i) + sequence.get(i + 1)) / 2.0;
            prefixSum[i + 1] = prefixSum[i] + area;
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = prefixSum[end] - prefixSum[start];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k1 = 5;
        int[][] ranges1 = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        double[] result1 = solution.solution(k1, ranges1);

        int k2 = 3;
        int[][] ranges2 = {{0, 0}, {1, -2}, {3, -3}};
        double[] result2 = solution.solution(k2, ranges2);

        System.out.println(Arrays.toString(result1)); // [33.0, 31.5, 0.0, -1.0]
        System.out.println(Arrays.toString(result2)); // [47.0, 36.0, 12.0]
    }
}