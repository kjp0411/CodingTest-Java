package programmers.lv2.p72411;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int courseSize : course) {
            Map<String, Integer> combinationCounts = new HashMap<>();

            for (String order : orders) {
                if (order.length() < courseSize) {
                    continue;
                }

                char[] menus = order.toCharArray();
                Arrays.sort(menus);

                createCombinations(
                        menus,
                        courseSize,
                        0,
                        new StringBuilder(),
                        combinationCounts
                );
            }

            int maximumCount = 0;

            for (int count : combinationCounts.values()) {
                maximumCount = Math.max(maximumCount, count);
            }

            // 최소 2명의 손님이 주문한 조합만 선택
            if (maximumCount < 2) {
                continue;
            }

            for (Map.Entry<String, Integer> entry : combinationCounts.entrySet()) {
                if (entry.getValue() == maximumCount) {
                    answer.add(entry.getKey());
                }
            }
        }

        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }

    private void createCombinations(
            char[] menus,
            int courseSize,
            int startIndex,
            StringBuilder combination,
            Map<String, Integer> combinationCounts
    ) {
        if (combination.length() == courseSize) {
            String menuCombination = combination.toString();

            combinationCounts.put(
                    menuCombination,
                    combinationCounts.getOrDefault(menuCombination, 0) + 1
            );

            return;
        }

        for (int index = startIndex; index < menus.length; index++) {
            combination.append(menus[index]);

            createCombinations(
                    menus,
                    courseSize,
                    index + 1,
                    combination,
                    combinationCounts
            );

            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] orders1 = {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        int[] course1 = {2, 3, 4};

        String[] orders2 = {
                "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
        };
        int[] course2 = {2, 3, 5};

        String[] orders3 = {
                "XYZ", "XWY", "WXA"
        };
        int[] course3 = {2, 3, 4};

        String[] result1 = solution.solution(orders1, course1);
        String[] result2 = solution.solution(orders2, course2);
        String[] result3 = solution.solution(orders3, course3);

        System.out.println(Arrays.toString(result1)); // [AC, ACDE, BCFG, CDE]
        System.out.println(Arrays.toString(result2)); // [ACD, AD, ADE, CD, XYZ]
        System.out.println(Arrays.toString(result3)); // [WX, XY]
    }
}