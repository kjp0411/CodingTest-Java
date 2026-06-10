package programmers.lv3.p42628;

// https://school.programmers.co.kr/learn/courses/30/lessons/42628

import java.util.Arrays;
import java.util.TreeMap;

public class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");

            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else {
                if (map.isEmpty()) {
                    continue;
                }

                if (number == 1) {
                    int maxKey = map.lastKey();

                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                } else {
                    int minKey = map.firstKey();

                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{map.lastKey(), map.firstKey()};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] operations1 = {
            "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"
        };
        String[] operations2 = {
            "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
        };

        int[] result1 = solution.solution(operations1);
        int[] result2 = solution.solution(operations2);

        System.out.println(Arrays.toString(result1)); // [0, 0]
        System.out.println(Arrays.toString(result2)); // [333, -45]
    }
}