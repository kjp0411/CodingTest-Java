package programmers.lv2.p12981;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = new int[2];

        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (usedWords.contains(current)) {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;

                return result;
            }

            if (i > 0) {
                String previous = words[i - 1];
                char previousLast = previous.charAt(previous.length() - 1);
                char currentFirst = current.charAt(0);

                if (previousLast != currentFirst) {
                    result[0] = (i % n) + 1;
                    result[1] = (i / n) + 1;

                    return result;
                }
            }

            usedWords.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int n2 = 5;
        int n3 = 2;

        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        int[] result1 = solution.solution(n1, words1);
        int[] result2 = solution.solution(n2, words2);
        int[] result3 = solution.solution(n3, words3);

        System.out.println(Arrays.toString(result1)); // [3, 3]
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3)); // [1, 3]
    }
}