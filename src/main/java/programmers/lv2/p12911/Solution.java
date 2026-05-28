package programmers.lv2.p12911;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911

public class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int next = n + 1;

        while (Integer.bitCount(next) != count) {
            next++;
        }

        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s1 = 78;
        int s2 = 15;
        int result1 = solution.solution(s1);
        int result2 = solution.solution(s2);

        System.out.println(result1); // 83
        System.out.println(result2); // 23
    }
}