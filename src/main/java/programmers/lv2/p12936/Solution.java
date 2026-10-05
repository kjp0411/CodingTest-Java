package programmers.lv2.p12936;

// https://school.programmers.co.kr/learn/courses/30/lessons/12936

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int n, long k) {
        List<Integer> remainingPeople = new ArrayList<>();

        for (int person = 1; person <= n; person++) {
            remainingPeople.add(person);
        }

        long factorial = 1;

        for (int number = 2; number <= n; number++) {
            factorial *= number;
        }

        int[] answer = new int[n];

        k--;

        for (int position = 0; position < n; position++) {
            int remainingCount = n - position;

            factorial /= remainingCount;

            int selectedIndex = (int) (k / factorial);
            answer[position] = remainingPeople.remove(selectedIndex);

            k %= factorial;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n1 = 3;
        long k1 = 5;
        int[] result1 = solution.solution(n1, k1);

        System.out.println(Arrays.toString(result1)); // [3, 1, 2]
    }
}