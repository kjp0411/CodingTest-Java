package programmers.lv2.p17687;

// https://school.programmers.co.kr/learn/courses/30/lessons/17687

public class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        int number = 0;

        while (sequence.length() < t * m) {
            String converted = Integer.toString(number, n).toUpperCase();
            sequence.append(converted);
            number++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int index = (p - 1) + (i * m);
            result.append(sequence.charAt(index));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2;
        int t1 = 4;
        int m1 = 2;
        int p1 = 1;
        String result1 = solution.solution(n1, t1, m1, p1);

        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;
        String result2 = solution.solution(n2, t2, m2, p2);

        int n3 = 16;
        int t3 = 16;
        int m3 = 2;
        int p3 = 2;
        String result3 = solution.solution(n3, t3, m3, p3);

        System.out.println(result1); // 0111
        System.out.println(result2); // 02468ACE11111111
        System.out.println(result3); // 13579BDF01234567
    }
}