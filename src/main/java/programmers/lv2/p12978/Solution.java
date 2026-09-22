package programmers.lv2.p12978;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    private static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int[][] road, int k) {
        List<List<Road>> graph = createGraph(n, road);
        int[] minimumTimes = findMinimumTimes(graph, n);

        int answer = 0;

        for (int minimumTime : minimumTimes) {
            if (minimumTime <= k) {
                answer++;
            }
        }

        return answer;
    }

    private List<List<Road>> createGraph(int n, int[][] road) {
        List<List<Road>> graph = new ArrayList<>();

        for (int village = 0; village <= n; village++) {
            graph.add(new ArrayList<>());
        }

        for (int[] roadInformation : road) {
            int firstVillage = roadInformation[0];
            int secondVillage = roadInformation[1];
            int travelTime = roadInformation[2];

            graph.get(firstVillage).add(
                    new Road(secondVillage, travelTime)
            );

            graph.get(secondVillage).add(
                    new Road(firstVillage, travelTime)
            );
        }

        return graph;
    }

    private int[] findMinimumTimes(
            List<List<Road>> graph,
            int n
    ) {
        int[] minimumTimes = new int[n + 1];
        Arrays.fill(minimumTimes, INF);

        Queue<Road> queue = new PriorityQueue<>();

        minimumTimes[1] = 0;
        queue.offer(new Road(1, 0));

        while (!queue.isEmpty()) {
            Road current = queue.poll();

            if (current.travelTime > minimumTimes[current.village]) {
                continue;
            }

            for (Road next : graph.get(current.village)) {
                int nextTime = current.travelTime + next.travelTime;

                if (nextTime < minimumTimes[next.village]) {
                    minimumTimes[next.village] = nextTime;
                    queue.offer(new Road(next.village, nextTime));
                }
            }
        }

        return minimumTimes;
    }

    private static class Road implements Comparable<Road> {
        private final int village;
        private final int travelTime;

        private Road(int village, int travelTime) {
            this.village = village;
            this.travelTime = travelTime;
        }

        @Override
        public int compareTo(Road other) {
            return Integer.compare(this.travelTime, other.travelTime);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5;
        int[][] road1 = {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };
        int k1 = 3;

        int n2 = 6;
        int[][] road2 = {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 3},
                {3, 5, 2},
                {3, 5, 3},
                {5, 6, 1}
        };
        int k2 = 4;

        int result1 = solution.solution(n1, road1, k1);
        int result2 = solution.solution(n2, road2, k2);

        System.out.println(result1); // 4
        System.out.println(result2); // 4
    }
}