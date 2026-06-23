package programmers.lv3.p67258;

// https://school.programmers.co.kr/learn/courses/30/lessons/67258

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>();

        for (String gem : gems) {
            gemTypes.add(gem);
        }

        int totalTypes = gemTypes.size();

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == totalTypes) {
                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    start = left;
                    end = right;
                }

                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);

                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }

                left++;
            }

            right++;
        }

        return new int[]{start + 1, end + 1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] result1 = solution.solution(gems1);
        int[] result2 = solution.solution(gems2);
        int[] result3 = solution.solution(gems3);
        int[] result4 = solution.solution(gems4);

        System.out.println(result1[0] + ", " + result1[1]); // 3, 7
        System.out.println(result2[0] + ", " + result2[1]); // 1, 3
        System.out.println(result3[0] + ", " + result3[1]); // 1, 1
        System.out.println(result4[0] + ", " + result4[1]); // 1, 5
    }
}