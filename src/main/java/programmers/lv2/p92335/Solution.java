package programmers.lv2.p92335;

// https://school.programmers.co.kr/learn/courses/30/lessons/92335

public class Solution {
    public int solution(int n, int k) {
        String converted = Integer.toString(n, k);
        String[] numbers = converted.split("0");
        int answer = 0;

        for (String value : numbers) {
            if (value.isEmpty()) {
                continue;
            }

            long number = Long.parseLong(value);

            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }

        for (long i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 437674;
        int k1 = 3;
        int result1 = solution.solution(n1, k1);

        int n2 = 110011;
        int k2 = 10;
        int result2 = solution.solution(n2, k2);

        System.out.println(result1); // 3
        System.out.println(result2); // 2
    }
}