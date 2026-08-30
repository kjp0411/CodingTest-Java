package programmers.lv2.p42839;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        Set<Integer> primeNumbers = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        findPrimeNumbers(numbers, visited, 0, primeNumbers);

        return primeNumbers.size();
    }

    private void findPrimeNumbers(
        String numbers,
        boolean[] visited,
        int currentNumber,
        Set<Integer> primeNumbers
    ) {
        if (isPrime(currentNumber)) {
            primeNumbers.add(currentNumber);
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            int nextNumber =
                currentNumber * 10 + (numbers.charAt(i) - '0');

            findPrimeNumbers(
                numbers,
                visited,
                nextNumber,
                primeNumbers
            );

            visited[i] = false;
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int divisor = 2;
            divisor * divisor <= number;
            divisor++) {

            if (number % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String numbers1 = "17";
        int result1 = solution.solution(numbers1);

        String numbers2 = "011";
        int result2 = solution.solution(numbers2);

        System.out.println(result1); // 3
        System.out.println(result2); // 2
    }
}