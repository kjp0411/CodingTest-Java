package programmers.lv2.p12985;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985

public class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 8, a1 = 4, b1 = 7;

        int result1 = solution.solution(n1, a1, b1);

        System.out.println(result1); // 3
    }
}