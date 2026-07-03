package programmers.lv3.p68646;

// https://school.programmers.co.kr/learn/courses/30/lessons/68646

public class Solution {
    public int solution(int[] a) {
        int n = a.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[n - 1] = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a1 = {9, -1, -5};
        int[] a2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

        int result1 = solution.solution(a1);
        int result2 = solution.solution(a2);

        System.out.println(result1); // 3
        System.out.println(result2); // 6
    }
}