package programmers.lv2.p76502;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);

            if (isValid(rotated)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        int result1 = solution.solution(s1);
        int result2 = solution.solution(s2);
        int result3 = solution.solution(s3);
        int result4 = solution.solution(s4);

        System.out.println(result1); // 3
        System.out.println(result2); // 2
        System.out.println(result3); // 0
        System.out.println(result4); // 0
    }
}