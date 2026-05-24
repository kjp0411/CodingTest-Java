package programmers.lv1.p12919;

// https://school.programmers.co.kr/learn/courses/30/lessons/12919

public class Solution {
    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.solution(new String[]{"Jane", "Kim"});

        System.out.println(result);
    }
}