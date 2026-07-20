package programmers.lv2.p42747;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] citations = {3, 0, 6, 1, 5};
        int result = solution.solution(citations);

        System.out.println(result); // 3
    }
}