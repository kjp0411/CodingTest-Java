package programmers.lv3.p64062;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062

public class Solution {

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;

        for (int stone : stones) {
            right = Math.max(right, stone);
        }

        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int consecutive = 0;

        for (int stone : stones) {
            if (stone < people) {
                consecutive++;

                if (consecutive >= k) {
                    return false;
                }
            } else {
                consecutive = 0;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int result = solution.solution(stones, k);

        System.out.println(result); // 3
    }
}