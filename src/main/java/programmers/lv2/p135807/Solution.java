package programmers.lv2.p135807;

// https://school.programmers.co.kr/learn/courses/30/lessons/135807

public class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findArrayGcd(arrayA);
        int gcdB = findArrayGcd(arrayB);

        int candidateA = dividesNone(gcdA, arrayB) ? gcdA : 0;
        int candidateB = dividesNone(gcdB, arrayA) ? gcdB : 0;

        return Math.max(candidateA, candidateB);
    }

    private int findArrayGcd(int[] numbers) {
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            result = gcd(result, numbers[i]);

            if (result == 1) {
                break;
            }
        }

        return result;
    }

    private int gcd(int first, int second) {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }

        return first;
    }

    private boolean dividesNone(int divisor, int[] numbers) {
        if (divisor == 1) {
            return false;
        }

        for (int number : numbers) {
            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arrayA1 = {10, 17};
        int[] arrayB1 = {5, 20};
        int result1 = solution.solution(arrayA1, arrayB1);

        int[] arrayA2 = {10, 20};
        int[] arrayB2 = {5, 17};
        int result2 = solution.solution(arrayA2, arrayB2);

        int[] arrayA3 = {14, 35, 119};
        int[] arrayB3 = {18, 30, 102};
        int result3 = solution.solution(arrayA3, arrayB3);

        System.out.println(result1); // 0
        System.out.println(result2); // 10
        System.out.println(result3); // 7
    }
}