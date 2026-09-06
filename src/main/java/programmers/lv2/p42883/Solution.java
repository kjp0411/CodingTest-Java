package programmers.lv2.p42883;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883

public class Solution {
    public String solution(String number, int k) {
        char[] stack = new char[number.length()];

        int top = 0;
        int remainingRemovals = k;

        for (int i = 0; i < number.length(); i++) {
            char currentNumber = number.charAt(i);

            while (top > 0
                    && remainingRemovals > 0
                    && stack[top - 1] < currentNumber) {

                top--;
                remainingRemovals--;
            }

            stack[top] = currentNumber;
            top++;
        }

        int answerLength = number.length() - k;

        return new String(stack, 0, answerLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String numbers1 = "1924";
        int k1 = 2;
        String result1 = solution.solution(numbers1, k1);

        String numbers2 = "1231234";
        int k2 = 3;
        String result2 = solution.solution(numbers2, k2);

        String numbers3 = "4177252841";
        int k3 = 4;
        String result3 = solution.solution(numbers3, k3);

        System.out.println(result1); // 94
        System.out.println(result2); // 3234
        System.out.println(result3); // 775841
    }
}