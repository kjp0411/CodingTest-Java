package programmers.lv2.p86971;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int tower = 1; tower <= n; tower++) {
            graph[tower] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int firstTower = wire[0];
            int secondTower = wire[1];

            graph[firstTower].add(secondTower);
            graph[secondTower].add(firstTower);
        }

        int answer = n;

        for (int[] wire : wires) {
            int disconnectedTower1 = wire[0];
            int disconnectedTower2 = wire[1];

            int firstNetworkSize = countConnectedTowers(
                    graph,
                    n,
                    disconnectedTower1,
                    disconnectedTower2
            );

            int secondNetworkSize = n - firstNetworkSize;

            int difference = Math.abs(
                    firstNetworkSize - secondNetworkSize
            );

            answer = Math.min(answer, difference);
        }

        return answer;
    }

    private int countConnectedTowers(
            List<Integer>[] graph,
            int n,
            int disconnectedTower1,
            int disconnectedTower2
    ) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(disconnectedTower1);
        visited[disconnectedTower1] = true;

        int connectedTowerCount = 0;

        while (!queue.isEmpty()) {
            int currentTower = queue.poll();
            connectedTowerCount++;

            for (int nextTower : graph[currentTower]) {
                if (isDisconnectedWire(
                        currentTower,
                        nextTower,
                        disconnectedTower1,
                        disconnectedTower2
                )) {
                    continue;
                }

                if (visited[nextTower]) {
                    continue;
                }

                visited[nextTower] = true;
                queue.offer(nextTower);
            }
        }

        return connectedTowerCount;
    }

    private boolean isDisconnectedWire(
            int currentTower,
            int nextTower,
            int disconnectedTower1,
            int disconnectedTower2
    ) {
        return (currentTower == disconnectedTower1
                && nextTower == disconnectedTower2)
                || (currentTower == disconnectedTower2
                && nextTower == disconnectedTower1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 9;
        int[][] wires1 = {
                {1, 3}, {2, 3}, {3, 4}, {4, 5},
                {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };

        int n2 = 4;
        int[][] wires2 = {
                {1, 2}, {2, 3}, {3, 4}
        };

        int n3 = 7;
        int[][] wires3 = {
                {1, 2}, {2, 7}, {3, 7},
                {3, 4}, {4, 5}, {6, 7}
        };

        System.out.println(solution.solution(n1, wires1)); // 3
        System.out.println(solution.solution(n2, wires2)); // 0
        System.out.println(solution.solution(n3, wires3)); // 1
    }
}