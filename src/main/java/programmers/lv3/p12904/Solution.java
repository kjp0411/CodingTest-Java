package programmers.lv3.p12904;

// https://school.programmers.co.kr/learn/courses/30/lessons/12904

public class Solution {
    public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, getPalindromeLength(s, i, i));
            answer = Math.max(answer, getPalindromeLength(s, i, i + 1));
        }

        return answer;
    }

    private int getPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length()
            && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abcdcba";
        String s2 = "abacde";

        System.out.println(solution.solution(s1)); // 7
        System.out.println(solution.solution(s2)); // 3
    }
}