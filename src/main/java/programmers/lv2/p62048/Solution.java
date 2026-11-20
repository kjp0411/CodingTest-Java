package programmers.lv2.p62048;

// https://school.programmers.co.kr/learn/courses/30/lessons/62048

public class Solution {

    public long solution(int w, int h) {
        long totalSquares = (long) w * h;

        int gcd = getGcd(w, h);

        long unusableSquares = (long) w + h - gcd;

        return totalSquares - unusableSquares;
    }

    private int getGcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int w = 8;
        int h = 12;

        long result = solution.solution(w, h);

        System.out.println(result); // 80
    }
}