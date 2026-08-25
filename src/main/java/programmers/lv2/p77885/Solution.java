package programmers.lv2.p77885;

// https://school.programmers.co.kr/learn/courses/30/lessons/77885

import java.util.Arrays;

public class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            if (number % 2 == 0) {
                answer[i] = number + 1;
            } else {
                long lowestZeroBit = (~number) & (number + 1);

                answer[i] =
                    number + lowestZeroBit - (lowestZeroBit >> 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        long[] numbers = {2, 7};
        long[] result = solution.solution(numbers);

        System.out.println(Arrays.toString(result)); // [3, 11]
    }
}