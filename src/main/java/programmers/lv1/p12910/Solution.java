package programmers.lv1.p12910;

// https://school.programmers.co.kr/learn/courses/30/lessons/12910

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result1 = solution.solution(new int[]{5, 9, 7, 10}, 5);
        int[] result2 = solution.solution(new int[]{2, 36, 1, 3}, 1);
        int[] result3 = solution.solution(new int[]{3, 2, 6}, 10);

        System.out.println(Arrays.toString(result1)); // [5, 10]
        System.out.println(Arrays.toString(result2)); // [1, 2, 3, 36]
        System.out.println(Arrays.toString(result3)); // [-1]
    }
}