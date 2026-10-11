package programmers.lv2.p67257;

// https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char[] OPERATORS = {'+', '-', '*'};

    private long maximumPrize;

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        parseExpression(expression, numbers, operators);

        maximumPrize = 0;

        permutePriorities(
                0,
                new char[OPERATORS.length],
                new boolean[OPERATORS.length],
                numbers,
                operators
        );

        return maximumPrize;
    }

    private void parseExpression(
            String expression,
            List<Long> numbers,
            List<Character> operators
    ) {
        long number = 0;

        for (int index = 0; index < expression.length(); index++) {
            char character = expression.charAt(index);

            if (Character.isDigit(character)) {
                number = number * 10 + (character - '0');
            } else {
                numbers.add(number);
                operators.add(character);
                number = 0;
            }
        }

        numbers.add(number);
    }

    private void permutePriorities(
            int depth,
            char[] priorities,
            boolean[] used,
            List<Long> numbers,
            List<Character> operators
    ) {
        if (depth == OPERATORS.length) {
            long result = calculate(numbers, operators, priorities);
            maximumPrize = Math.max(maximumPrize, Math.abs(result));
            return;
        }

        for (int index = 0; index < OPERATORS.length; index++) {
            if (used[index]) {
                continue;
            }

            used[index] = true;
            priorities[depth] = OPERATORS[index];

            permutePriorities(
                    depth + 1,
                    priorities,
                    used,
                    numbers,
                    operators
            );

            used[index] = false;
        }
    }

    private long calculate(
            List<Long> numbers,
            List<Character> operators,
            char[] priorities
    ) {
        List<Long> remainingNumbers = new ArrayList<>(numbers);
        List<Character> remainingOperators = new ArrayList<>(operators);

        for (char priority : priorities) {
            int index = 0;

            while (index < remainingOperators.size()) {
                if (remainingOperators.get(index) == priority) {
                    long result = apply(
                            remainingNumbers.get(index),
                            remainingNumbers.get(index + 1),
                            priority
                    );

                    remainingNumbers.set(index, result);
                    remainingNumbers.remove(index + 1);
                    remainingOperators.remove(index);
                } else {
                    index++;
                }
            }
        }

        return remainingNumbers.get(0);
    }

    private long apply(long first, long second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            default:
                return first * second;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        long result1 = solution.solution(expression1);
        long result2 = solution.solution(expression2);

        System.out.println(result1); // 60420
        System.out.println(result2); // 300
    }
}