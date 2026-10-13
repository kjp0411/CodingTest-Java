package programmers.lv2.p60058;

// https://school.programmers.co.kr/learn/courses/30/lessons/60058

public class Solution {
    public String solution(String p) {
        return convertParentheses(p);
    }

    private String convertParentheses(String parentheses) {
        if (parentheses.isEmpty()) {
            return "";
        }

        int balance = 0;
        int splitIndex = 0;

        for (int index = 0; index < parentheses.length(); index++) {
            char bracket = parentheses.charAt(index);

            balance += bracket == '(' ? 1 : -1;

            if (balance == 0) {
                splitIndex = index + 1;
                break;
            }
        }

        String u = parentheses.substring(0, splitIndex);
        String v = parentheses.substring(splitIndex);

        if (isCorrectParentheses(u)) {
            return u + convertParentheses(v);
        }

        StringBuilder result = new StringBuilder();

        result.append('(');
        result.append(convertParentheses(v));
        result.append(')');

        for (int index = 1; index < u.length() - 1; index++) {
            char bracket = u.charAt(index);
            result.append(bracket == '(' ? ')' : '(');
        }

        return result.toString();
    }

    private boolean isCorrectParentheses(String parentheses) {
        int balance = 0;

        for (int index = 0; index < parentheses.length(); index++) {
            char bracket = parentheses.charAt(index);

            balance += bracket == '(' ? 1 : -1;

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        String result1 = solution.solution(p1);
        String result2 = solution.solution(p2);
        String result3 = solution.solution(p3);

        System.out.println(result1); // (()())()
        System.out.println(result2); // ()
        System.out.println(result3); // ()(())()
    }
}