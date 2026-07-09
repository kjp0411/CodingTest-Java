package programmers.lv3.p49191;

// https://school.programmers.co.kr/learn/courses/30/lessons/49191

public class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner][loser] = true;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (graph[start][mid] && graph[mid][end]) {
                        graph[start][end] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int player = 1; player <= n; player++) {
            int count = 0;

            for (int other = 1; other <= n; other++) {
                if (player == other) {
                    continue;
                }

                if (graph[player][other] || graph[other][player]) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5;
        int[][] results1 = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}
        };

        int result1 = solution.solution(n1, results1);

        System.out.println(result1); // 2
    }
}