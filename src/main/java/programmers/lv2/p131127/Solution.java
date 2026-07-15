package programmers.lv2.p131127;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int windowSize = 0;

        for (int i = 0; i < number.length; i++) {
            windowSize += number[i];
        }

        int result = 0;

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < windowSize; i++) {
            String item = discount[i];

            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        for (int left = 0; left + windowSize <= discount.length; left++) {
            boolean isValid = true;

            for (int i = 0; i < want.length; i++) {
                if (countMap.getOrDefault(want[i], 0) != number[i]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result++;
            }

            if (left + windowSize < discount.length) {
                String removedItem = discount[left];
                String addedItem = discount[left + windowSize];

                countMap.put(
                    removedItem,
                    countMap.get(removedItem) - 1
                );

                countMap.put(
                    addedItem,
                    countMap.getOrDefault(addedItem, 0) + 1
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int result1 = solution.solution(want1, number1, discount1);

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int result2 = solution.solution(want2, number2, discount2);

        System.out.println(result1); // 3
        System.out.println(result2); // 0
    }
}