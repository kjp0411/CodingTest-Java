package programmers.lv3.p132266;

// https://school.programmers.co.kr/learn/courses/30/lessons/132266

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[current] + 1;
                queue.offer(next);
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 3;
        int[][] roads1 = {
            {1, 2},
            {2, 3}
        };
        int[] sources1 = {2, 3};
        int destination1 = 1;

        int n2 = 5;
        int[][] roads2 = {
            {1, 2},
            {1, 4},
            {2, 4},
            {2, 5},
            {4, 5}
        };
        int[] sources2 = {1, 3, 5};
        int destination2 = 5;

        int[] result1 = solution.solution(
            n1,
            roads1,
            sources1,
            destination1
        );

        int[] result2 = solution.solution(
            n2,
            roads2,
            sources2,
            destination2
        );

        System.out.println(Arrays.toString(result1)); // [1, 2]
        System.out.println(Arrays.toString(result2)); // [2, -1, 0]
    }
}