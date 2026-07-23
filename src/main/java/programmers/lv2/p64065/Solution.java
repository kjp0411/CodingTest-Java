package programmers.lv2.p64065;

// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] solution(String s) {
        String[] groups = s.substring(2, s.length() - 2).split("\\},\\{");

        Arrays.sort(groups, Comparator.comparingInt(group -> group.split(",").length));

        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (String group : groups) {
            String[] numbers = group.split(",");

            for (String number : numbers) {
                int value = Integer.parseInt(number);

                if (set.add(value)) {
                    result.add(value);
                }
            }
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result1 = solution.solution(s1);

        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] result2 = solution.solution(s2);

        String s3 = "{{20,111},{111}}";
        int[] result3 = solution.solution(s3);

        String s4 = "{{123}}";
        int[] result4 = solution.solution(s4);

        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] result5 = solution.solution(s5);

        System.out.println(Arrays.toString(result1)); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(result2)); // [2, 1, 3, 4]
        System.out.println(Arrays.toString(result3)); // [111, 20]
        System.out.println(Arrays.toString(result4)); // [123]
        System.out.println(Arrays.toString(result5)); // [3, 2, 4, 1]
    }
}