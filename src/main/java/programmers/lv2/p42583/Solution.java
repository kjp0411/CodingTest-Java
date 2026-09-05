package programmers.lv2.p42583;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int solution(
            int bridgeLength,
            int weight,
            int[] truckWeights
    ) {
        Queue<Truck> bridge = new ArrayDeque<>();

        int currentTime = 0;
        int currentWeight = 0;
        int lastExitTime = 0;

        for (int truckWeight : truckWeights) {
            currentTime++;

            while (!bridge.isEmpty()
                    && bridge.peek().exitTime <= currentTime) {

                currentWeight -= bridge.poll().weight;
            }

            while (currentWeight + truckWeight > weight) {
                currentTime = bridge.peek().exitTime;

                while (!bridge.isEmpty()
                        && bridge.peek().exitTime <= currentTime) {

                    currentWeight -= bridge.poll().weight;
                }
            }

            lastExitTime = currentTime + bridgeLength;

            bridge.offer(new Truck(truckWeight, lastExitTime));
            currentWeight += truckWeight;
        }

        return lastExitTime;
    }

    private static class Truck {
        private final int weight;
        private final int exitTime;

        private Truck(int weight, int exitTime) {
            this.weight = weight;
            this.exitTime = exitTime;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result1 = solution.solution(
                2,
                10,
                new int[]{7, 4, 5, 6}
        );

        int result2 = solution.solution(
                100,
                100,
                new int[]{10}
        );

        int result3 = solution.solution(
                100,
                100,
                new int[]{
                        10, 10, 10, 10, 10,
                        10, 10, 10, 10, 10
                }
        );

        System.out.println(result1); // 8
        System.out.println(result2); // 101
        System.out.println(result3); // 110
    }
}