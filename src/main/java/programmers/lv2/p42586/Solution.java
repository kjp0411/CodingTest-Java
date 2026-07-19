package programmers.lv2.p42586;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int deployDay = (100 - progresses[0] + speeds[0] - 1) / speeds[0];
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            int requiredDay = (100 - progresses[i] + speeds[i] - 1) / speeds[i];

            if (requiredDay <= deployDay) {
                count++;
            } else {
                result.add(count);

                deployDay = requiredDay;
                count = 1;
            }
        }
        result.add(count);

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = solution.solution(progresses1, speeds1);

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = solution.solution(progresses2, speeds2);

        System.out.println(Arrays.toString(result1)); // [2, 1]
        System.out.println(Arrays.toString(result2)); // [1, 3, 2]
    }
}