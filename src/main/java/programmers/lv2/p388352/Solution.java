package programmers.lv2.p388352;

// https://school.programmers.co.kr/learn/courses/30/lessons/388352

public class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        for (int a = 1; a <= n - 4; a++) {
            for (int b = a + 1; b <= n - 3; b++) {
                for (int c = b + 1; c <= n - 2; c++) {
                    for (int d = c + 1; d <= n - 1; d++) {
                        for (int e = d + 1; e <= n; e++) {
                            int[] code = {a, b, c, d, e};

                            if (isValidCode(code, q, ans)) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    private boolean isValidCode(int[] code, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;

            for (int number : code) {
                for (int queryNumber : q[i]) {
                    if (number == queryNumber) {
                        matchCount++;
                        break;
                    }
                }
            }

            if (matchCount != ans[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 10;
        int[][] q1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}
        };
        int[] ans1 = {2, 3, 4, 3, 3};
        int result1 = solution.solution(n1, q1, ans1);

        int n2 = 15;
        int[][] q2 = {
                {2, 3, 9, 12, 13},
                {1, 4, 6, 7, 9},
                {1, 2, 8, 10, 12},
                {6, 7, 11, 13, 15},
                {1, 4, 10, 11, 14}
        };
        int[] ans2 = {2, 1, 3, 0, 1};
        int result2 = solution.solution(n2, q2, ans2);

        System.out.println(result1); // 3
        System.out.println(result2); // 5
    }
}