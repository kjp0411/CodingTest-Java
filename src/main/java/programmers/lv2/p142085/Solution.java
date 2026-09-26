package programmers.lv2.p142085;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> invincibleRounds = new PriorityQueue<>();
        int remainingSoldiers = n;

        for (int round = 0; round < enemy.length; round++) {
            invincibleRounds.offer(enemy[round]);

            // 무적권을 사용할 수 있는 횟수를 초과한 경우
            if (invincibleRounds.size() > k) {
                int smallestEnemyCount = invincibleRounds.poll();
                remainingSoldiers -= smallestEnemyCount;
            }

            if (remainingSoldiers < 0) {
                return round;
            }
        }

        return enemy.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 7;
        int k1 = 3;
        int[] enemy1 = {4, 2, 4, 5, 3, 3, 1};
        int result1 = solution.solution(n1, k1, enemy1);

        int n2 = 2;
        int k2 = 4;
        int[] enemy2 = {3, 3, 3, 3};
        int result2 = solution.solution(n2, k2, enemy2);

        System.out.println(result1); // 5
        System.out.println(result2); // 4
    }
}