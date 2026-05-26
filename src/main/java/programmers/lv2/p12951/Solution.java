package programmers.lv2.p12951;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951

public class Solution {
    public String solution(String s) {
        s = s.toLowerCase();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i-1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = solution.solution("3people unFollowed me");
        String s2 = solution.solution("for the last week");
        System.out.println(s1); // "3people Unfollowed Me"
        System.out.println(s2); // "For The Last Week"
    }
}