package programmers.lv3.p161988;

// https://school.programmers.co.kr/learn/courses/30/lessons/161988

public class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        long maxPulse1 = 0;
        long maxPulse2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            long value = sequence[i];

            if (i % 2 == 1) {
                value *= -1;
            }

            long reverseValue = -value;

            maxPulse1 = Math.max(value, maxPulse1 + value);
            maxPulse2 = Math.max(reverseValue, maxPulse2 + reverseValue);

            answer = Math.max(answer, Math.max(maxPulse1, maxPulse2));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        long result = solution.solution(sequence);

        System.out.println(result); // 10
    }
}