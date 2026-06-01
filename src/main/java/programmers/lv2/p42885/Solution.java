package programmers.lv2.p42885;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boat = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            boat++;
        }

        return boat;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] n1 = {70, 50, 80, 50};
        int[] n2 = {70, 80, 50};

        int result1 = solution.solution(n1, 100);
        int result2 = solution.solution(n2, 100);

        System.out.println(result1); // 3
        System.out.println(result2); // 3
    }
}