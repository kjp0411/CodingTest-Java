package programmers.lv3.p43162;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];

        int networkCount = 0;

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCount++;
                bfs(i, n, computers, visited);
            }
        }

        return networkCount;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < n; next++) {
                if (computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int n2 = 3;

        int[][] computers1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int [][] computers2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        int result1 = solution.solution(n1, computers1);
        int result2 = solution.solution(n2, computers2);

        System.out.println(result1); // 2
        System.out.println(result2); // 1
    }
}