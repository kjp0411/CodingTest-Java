package programmers.lv2.p17684;

// https://school.programmers.co.kr/learn/courses/30/lessons/17684

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int nextIndex = 27;
        int position = 0;

        while (position < msg.length()) {
            String word = String.valueOf(msg.charAt(position));
            int nextPosition = position + 1;

            while (nextPosition < msg.length()) {
                String nextWord = word + msg.charAt(nextPosition);

                if (!dictionary.containsKey(nextWord)) {
                    break;
                }

                word = nextWord;
                nextPosition++;
            }

            result.add(dictionary.get(word));

            if (nextPosition < msg.length()) {
                String newWord = word + msg.charAt(nextPosition);
                dictionary.put(newWord, nextIndex++);
            }

            position = nextPosition;
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        int[] result1 = solution.solution(msg1);
        int[] result2 = solution.solution(msg2);
        int[] result3 = solution.solution(msg3);

        System.out.println(Arrays.toString(result1)); // [11, 1, 27, 15]
        System.out.println(Arrays.toString(result2)); // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(Arrays.toString(result3)); // [1, 2, 27, 29, 28, 31, 30]
    }
}