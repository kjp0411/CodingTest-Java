package programmers.lv2.p84512;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512

public class Solution {

    private final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private int count;
    private int answer;

    public int solution(String word) {
        count = 0;
        answer = 0;

        dfs(word, "");

        return answer;
    }

    private void dfs(String word, String current) {
        if (answer != 0 || current.length() == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            char vowel = vowels[i];
            String next = current + vowel;

            count++;

            if (next.equals(word)) {
                answer = count;
                return;
            }

            dfs(word, next);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        int result1 = solution.solution(word1);
        int result2 = solution.solution(word2);
        int result3 = solution.solution(word3);
        int result4 = solution.solution(word4);

        System.out.println(result1); // 6
        System.out.println(result2); // 10
        System.out.println(result3); // 1563
        System.out.println(result4); // 1189
    }
}