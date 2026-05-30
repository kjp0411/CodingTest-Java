package programmers.lv2.p12973;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution
{
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "baabaa";
        String s2 = "cdcd";

        int result1 = solution.solution(s1);
        int result2 = solution.solution(s2);

        System.out.println(result1); // 1
        System.out.println(result2); // 0
    }
}