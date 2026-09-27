package programmers.lv2.p12899;

// https://school.programmers.co.kr/learn/courses/30/lessons/12899

public class Solution {
    private static final char[] DIGITS = {'1', '2', '4'};

    public String solution(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;

            int remainder = n % 3;
            result.append(DIGITS[remainder]);

            n /= 3;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;

        String result1 = solution.solution(n1);
        String result2 = solution.solution(n2);
        String result3 = solution.solution(n3);
        String result4 = solution.solution(n4);

        System.out.println(result1); // 1
        System.out.println(result2); // 2
        System.out.println(result3); // 4
        System.out.println(result4); // 11
    }
}