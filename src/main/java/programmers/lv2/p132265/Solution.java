package programmers.lv2.p132265;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int current = topping[0];
        int answer = 0;

        left.put(current, left.getOrDefault(current, 0) + 1);

        for (int value : topping) {
            right.put(value, right.getOrDefault(value, 0) + 1);
        }

        right.put(current, right.get(current) - 1);

        for (int i = 1; i < topping.length; i++) {
            if (right.get(current) == 0) {
                right.remove(current);
            }

            if (left.size() == right.size()) {
                answer++;
            }

            current = topping[i];

            right.put(current, right.get(current) - 1);

            left.put(current, left.getOrDefault(current, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int result1 = solution.solution(topping1);

        int[] topping2 = {1, 2, 3, 1, 4};
        int result2 = solution.solution(topping2);

        System.out.println(result1); // 2
        System.out.println(result2); // 0
    }
}