package programmers.lv3.p67259;

// https://school.programmers.co.kr/learn/courses/30/lessons/67259

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int INF = Integer.MAX_VALUE;

    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};

    public int solution(int[][] board) {
        int n = board.length;

        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], INF);
            }
        }

        Arrays.fill(cost[0][0], 0);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                int nextCost;

                if (current.dir == -1 || current.dir == dir) {
                    nextCost = current.cost + 100;
                } else {
                    nextCost = current.cost + 600;
                }

                if (nextCost < cost[nx][ny][dir]) {
                    cost[nx][ny][dir] = nextCost;
                    queue.offer(new Node(nx, ny, dir, nextCost));
                }
            }
        }

        int answer = INF;

        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, cost[n - 1][n - 1][dir]);
        }

        return answer;
    }

    private static class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] board1 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        int[][] board2 = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };

        int[][] board3 = {
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 0}
        };

        int[][] board4 = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}
        };

        int result1 = solution.solution(board1);
        int result2 = solution.solution(board2);
        int result3 = solution.solution(board3);
        int result4 = solution.solution(board4);

        System.out.println(result1); // 900
        System.out.println(result2); // 3800
        System.out.println(result3); // 2100
        System.out.println(result4); // 3200
    }
}