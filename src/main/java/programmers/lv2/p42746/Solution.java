package programmers.lv2.p42746;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String[] values = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            values[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(values, (first, second) ->
            (second + first).compareTo(first + second)
        );

        if (values[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (String value : values) {
            answer.append(value);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] numbers1 = {6, 10, 2};
        String result1 = solution.solution(numbers1);

        int[] numbers2 = {3, 30, 34, 5, 9};
        String result2 = solution.solution(numbers2);

        System.out.println(result1); // 6210
        System.out.println(result2); // 9534330
    }
}