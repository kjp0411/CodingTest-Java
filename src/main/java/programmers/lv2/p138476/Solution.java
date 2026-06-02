package programmers.lv2.p138476;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(countMap.values());

        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int selected = 0;

        for (int count : counts) {
            selected += count;
            answer++;

            if (selected >= k) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int k1 = 6;
        int k2 = 4;
        int k3 = 2;

        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

        int result1 = solution.solution(k1, tangerine1);
        int result2 = solution.solution(k2, tangerine2);
        int result3 = solution.solution(k3, tangerine3);

        System.out.println(result1); // 3
        System.out.println(result2); // 2
        System.out.println(result3); // 1
    }
}