package programmers.lv1.p12948;

// https://school.programmers.co.kr/learn/courses/30/lessons/12948

public class Solution {

    public String solution(String phone_number) {
        String answer = "";

        for (int i = 0; i < phone_number.length(); i++) {
            if (i < phone_number.length() - 4) {
                answer += "*";
            } else {
                answer += phone_number.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.solution("01033334444");

        System.out.println(result);
    }
}