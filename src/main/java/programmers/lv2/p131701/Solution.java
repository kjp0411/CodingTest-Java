package programmers.lv2.p131701;

// https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] extended = new int[n * 2];

        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }

        Set<Integer> set = new HashSet<>();

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int length = 1; length <= n; length++) {
                sum += extended[start + length - 1];
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] elements = {7, 9, 1, 1, 4};

        int result = solution.solution(elements);

        System.out.println(result); // 18
    }
}