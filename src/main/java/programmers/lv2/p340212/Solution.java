package programmers.lv2.p340212;

// https://school.programmers.co.kr/learn/courses/30/lessons/340212

public class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;   // 탐색할 최소 레벨
        int right = 0;  // 탐색할 최대 레벨

        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        int answer = right; // 지금까지 찾은 성공 레벨 중 최솟값

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSolve(diffs, times, mid, limit)) {
                // 풀 수 있음: 답을 저장하고 낮은 레벨 탐색
                answer = mid;
                right = mid - 1;
            } else {
                // 풀 수 없음: 높은 레벨 탐색
                left = mid + 1;
            }
        }

        return answer;

    }

    private boolean canSolve(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;

        // 퍼즐을 순서대로 확인하면서 소요 시간 누적
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] > level) {
                totalTime += (long) (diffs[i] - level) * (times[i] + times[i - 1]) + times[i];
            } else {
                totalTime += times[i];
            }
        }

        return totalTime <= limit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] diffs1 = {1, 5, 3};
        int[] times1 = {2, 4, 7};
        long limit1 = 30;
        int result1 = solution.solution(diffs1, times1, limit1);

        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59;
        int result2 = solution.solution(diffs2, times2, limit2);

        int[] diffs3 = {1, 328, 467, 209, 54};
        int[] times3 = {2, 7, 1, 4, 3};
        long limit3 = 1723;
        int result3 = solution.solution(diffs3, times3, limit3);

        int[] diffs4 = {1, 99999, 100000, 99995};
        int[] times4 = {9999, 9001, 9999, 9001};
        long limit4 = 3456789012L;
        int result4 = solution.solution(diffs4, times4, limit4);

        System.out.println(result1); // 3
        System.out.println(result2); // 2
        System.out.println(result3); // 294
        System.out.println(result4); // 39354
    }
}